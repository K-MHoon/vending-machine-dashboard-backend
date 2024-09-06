package com.kmhoon.dashboard.security.jwt;

import com.kmhoon.dashboard.security.login.UserInfo;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final JwtKey jwtKey;
    private final JwtTime jwtTime;

    public TokenInfo generate(Authentication authentication) {

        long now = (new Date()).getTime();

        Date accessTokenExpiresIn = new Date(now + jwtTime.getAccessTokenTime());

        UserInfo userDto = (UserInfo)authentication.getPrincipal();

        String accessToken = Jwts.builder()
                .claim("email", userDto.getEmail())
                .claim("name", userDto.getName())
                .claim("auth", userDto.getRoleNames())
                .setExpiration(accessTokenExpiresIn)
                .signWith(jwtKey.getKey(), SignatureAlgorithm.HS256)
                .compact();

        Date refreshExpiresIn = new Date(now + jwtTime.getRefreshTokenTime());

        String refreshToken = Jwts.builder()
                .claim("email", userDto.getEmail())
                .setExpiration(refreshExpiresIn)
                .signWith(jwtKey.getKey(), SignatureAlgorithm.HS256)
                .compact();

        return TokenInfo.builder()
                .grantType("Bearer")
                .email(userDto.getEmail())
                .name(userDto.getName())
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    public Authentication getAuthentication(String accessToken) {
        Claims claims = parseClaims(accessToken);
        if(claims.get("auth") == null) {
            throw new IllegalArgumentException("Jwt Auth Exception");
        }

        List<SimpleGrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        UserInfo user = new UserInfo(claims.get("email").toString(), claims.get("name").toString(), "", authorities);
        return new JwtAuthentication(user, "", authorities);
    }

    public Claims validate(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(jwtKey.getKey()).build().parseClaimsJws(token).getBody();
        }catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
            log.info("잘못된 JWT 서명입니다.", e);
            throw e;
        } catch (ExpiredJwtException e) {
            log.info("만료된 JWT 토큰입니다.", e);
            throw e;
        } catch (UnsupportedJwtException e) {
            log.info("지원되지 않는 JWT 토큰입니다.", e);
            throw e;
        } catch (IllegalArgumentException e) {
            log.info("JWT 토큰이 잘못되었습니다.", e);
            throw e;
        }
    }

    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder().setSigningKey(jwtKey.getKey())
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException ex) {
            return ex.getClaims();
        }
    }
}
