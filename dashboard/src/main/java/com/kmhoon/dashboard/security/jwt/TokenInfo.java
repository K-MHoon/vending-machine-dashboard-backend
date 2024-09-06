package com.kmhoon.dashboard.security.jwt;

import lombok.*;

/**
 * 토큰 정보를 반환한다.
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class TokenInfo {

    private String grantType;
    private String email;
    private String name;
    private String accessToken;
    private String refreshToken;
}
