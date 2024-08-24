package com.project.portfolio.core.exception;

import com.project.portfolio.core.exception.type.ValidationExceptionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends RuntimeException{
    private final ValidationExceptionType validationExceptionType;
    private String detail;

    public ValidationException(ValidationExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.validationExceptionType = exceptionType;
        this.detail = detail;
    }

    public ValidationException(ValidationExceptionType validationExceptionType) {
        super(validationExceptionType.getMessage());
        this.validationExceptionType = validationExceptionType;
        this.detail = validationExceptionType.getMessage();
    }
    @Override
    public String toString() {
        return "ValidationException{" +
                "errorCode='" + validationExceptionType.getErrorCode() + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
