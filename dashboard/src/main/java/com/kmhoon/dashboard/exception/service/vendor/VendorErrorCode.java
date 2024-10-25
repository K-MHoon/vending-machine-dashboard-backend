package com.kmhoon.dashboard.exception.service.vendor;

import com.kmhoon.dashboard.exception.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum VendorErrorCode implements ErrorCode {

    VENDOR_SEQ_NOT_FOUND("S-VENDOR-001", HttpStatus.BAD_REQUEST, "해당하는 자판기 제조사를 찾을 수 없습니다."),
    ;

    private final String code;
    private final HttpStatus httpStatus;
    private final String message;
}
