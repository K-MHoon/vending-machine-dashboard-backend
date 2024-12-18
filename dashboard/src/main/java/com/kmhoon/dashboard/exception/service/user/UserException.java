package com.kmhoon.dashboard.exception.service.user;

import com.kmhoon.dashboard.exception.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum UserException implements ErrorCode {

    USER_NOT_FOUND("S-USER-001",HttpStatus.NOT_FOUND, "해당 사용자를 찾을 수 없습니다."),
    ALREADY_CREATED_EMAIL("S-USER-002",HttpStatus.BAD_REQUEST, "이미 존재하는 이메일 입니다."),
    ROLE_NOT_FOUND("S-USER-003",HttpStatus.NOT_FOUND, "해당하는 역할(ROLE)을 찾을 수 없습니다."),


            ;
    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
