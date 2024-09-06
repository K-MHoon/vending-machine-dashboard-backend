package com.kmhoon.dashboard.security.login;

import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * 시큐리티 User Wrapping Dto
 */
@Getter
@ToString
public class UserInfo extends User {

    private String email;
    private String name;
    private String roleNames;

    public UserInfo(String email, String name, String password, Collection<? extends GrantedAuthority> authorities) {
        super(email, password, authorities);
        this.email = email;
        this.name = name;
        this.roleNames = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }
}
