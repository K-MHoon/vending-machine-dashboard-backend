package com.kmhoon.dashboard.exception.code;

import org.springframework.http.HttpStatus;

public abstract class AbstractCommonModuleErrorCode implements ErrorCode{

    @Override
    public String name() {
        return "CUSTOM_ERROR_CODE";
    }

    @Override
    public String getCode() {
        return "S-COMMON-001";
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
