package com.kmhoon.dashboard.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SecurityUtils {

    public static String getLoggedInUserId() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
