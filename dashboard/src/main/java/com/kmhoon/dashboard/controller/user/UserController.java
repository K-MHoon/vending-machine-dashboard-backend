package com.kmhoon.dashboard.controller.user;

import com.kmhoon.common.model.dto.service.user.CreateUserRequest;
import com.kmhoon.dashboard.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody @Valid CreateUserRequest request) {
        userService.register(request);
    }

}
