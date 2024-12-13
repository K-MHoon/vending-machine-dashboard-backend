package com.kmhoon.common.model.dto.service.user;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@ToString(exclude = "password")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class CreateUserRequest {

    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String username;
}
