package com.kmhoon.dashboard.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kmhoon.dashboard.exception.code.ErrorCode;
import lombok.*;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public final class ErrorResponse {

    private String code;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ValidationError> errors;

    public static ErrorResponse of(ErrorCode ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage(), null);
    }

    public static ErrorResponse of(ErrorCode ex, List<ValidationError> errors) {
        return new ErrorResponse(ex.getCode(), ex.getMessage(), errors);
    }

    @Getter
    @ToString
    @Builder
    public static class ValidationError {

        private String field;
        private String message;

        public static ValidationError of(final FieldError fieldError) {
            return ValidationError.builder()
                    .field(fieldError.getField())
                    .message(fieldError.getDefaultMessage())
                    .build();
        }
    }
}
