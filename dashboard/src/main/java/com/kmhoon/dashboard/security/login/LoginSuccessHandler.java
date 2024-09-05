package com.kmhoon.dashboard.security.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmhoon.dashboard.security.jwt.JwtTokenProvider;
import com.kmhoon.dashboard.security.jwt.TokenInfo;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;
    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        TokenInfo tokenInfo = jwtTokenProvider.generate(authentication);
        String tokenString = objectMapper.writeValueAsString(tokenInfo);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(tokenString);
    }
}
