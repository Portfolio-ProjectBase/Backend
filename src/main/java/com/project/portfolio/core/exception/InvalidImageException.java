package com.project.portfolio.core.exception;

import com.project.portfolio.core.exception.type.InvalidImageExceptionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidImageException extends RuntimeException{

    private final InvalidImageExceptionType invalidImageExceptionType;
    private final String detail;

    public InvalidImageException(InvalidImageExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.invalidImageExceptionType = exceptionType;
        this.detail = detail;
    }

    public InvalidImageException(InvalidImageExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.invalidImageExceptionType = exceptionType;
        this.detail=exceptionType.getMessage();

    }
    @Override
    public String toString() {
        return "InvalidImageException{" +
                "errorCode=" + invalidImageExceptionType.getErrorCode() +
                ", detail='" + detail + '\'' +
                '}';
    }
}
