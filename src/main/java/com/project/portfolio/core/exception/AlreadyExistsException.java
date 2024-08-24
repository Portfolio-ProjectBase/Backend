package com.project.portfolio.core.exception;

import com.project.portfolio.core.exception.type.AlreadyExistsExceptionType;
import lombok.Getter;

@Getter
public class AlreadyExistsException extends RuntimeException{
    private final AlreadyExistsExceptionType alreadyExistsExceptionType;
    private final String detail;
    //constructor overloading (yapıcı metot aşırı yükleme) örneğidir.
    public AlreadyExistsException(AlreadyExistsExceptionType exceptionType, String detail) {
        super(exceptionType.getMessage());
        this.alreadyExistsExceptionType = exceptionType;
        this.detail = detail;
    }

    public AlreadyExistsException(AlreadyExistsExceptionType exceptionType) {
        super(exceptionType.getMessage());
        this.alreadyExistsExceptionType = exceptionType;
        this.detail=exceptionType.getMessage();

    }
    @Override
    public String toString() {
        return "AlreadyExistsException{" +
                "errorCode=" + alreadyExistsExceptionType.getErrorCode() +
                ", detail='" + detail + '\'' +
                '}';
    }
}
