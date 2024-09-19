package com.kmhoon.dashboard.exception;

import com.kmhoon.dashboard.exception.code.AbstractCommonModuleErrorCode;
import com.kmhoon.dashboard.exception.code.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DashboardApiException extends RuntimeException{

    private final ErrorCode errorCode;

    public DashboardApiException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public DashboardApiException(String message, Throwable cause) {
        super(cause);
        this.errorCode = new AbstractCommonModuleErrorCode() {
            @Override
            public String getMessage() {
                return message;
            }
        };
    }
}
