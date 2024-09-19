package com.kmhoon.dashboard.exception.handler;

import com.kmhoon.dashboard.exception.DashboardApiException;
import com.kmhoon.dashboard.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DashboardApiException.class)
    public ResponseEntity<ErrorResponse> handleAuctionApiException(DashboardApiException ex) {
        log.debug("cause Dashboard Api Exception = ", ex);
        return ResponseEntity.status(ex.getErrorCode().getHttpStatus()).body(ErrorResponse.of(ex.getErrorCode()));
    }
}
