package com.kmhoon.dashboard.security.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * JWT Authentication
 */
public class JwtAuthentication extends UsernamePasswordAuthenticationToken {

    /**
     * 인증 전
     * @param principal
     * @param credentials
     */
    public JwtAuthentication(Object principal, Object credentials) {
        super(principal, credentials);
    }

    /**
     * 인증 성공
     * @param principal
     * @param credentials
     * @param authorities
     */
    public JwtAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }
}
