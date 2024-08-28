package com.kmhoon.dashboard.security.jwt;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 토큰 시간 관리
 */
@Component
@Getter
public class JwtTime {

    @Value("${jwt.time.access}")
    private Long accessTokenTime;

    @Value("${jwt.time.refresh}")
    private Long refreshTokenTime;
}
