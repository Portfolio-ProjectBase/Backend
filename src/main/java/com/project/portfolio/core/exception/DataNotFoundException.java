package com.project.portfolio.core.exception;

import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import lombok.Getter;

@Getter
public class DataNotFoundException extends RuntimeException{
    private final NotFoundExceptionType notFoundExceptionType;
    private final String detail;

    public DataNotFoundException(NotFoundExceptionType notFoundExceptionType, String detail) {
        super(notFoundExceptionType.getMessage());
        this.notFoundExceptionType = notFoundExceptionType;
        this.detail = detail;
    }

    public DataNotFoundException(NotFoundExceptionType notFoundExceptionType) {
        super(notFoundExceptionType.getMessage());
        this.notFoundExceptionType = notFoundExceptionType;
        this.detail = notFoundExceptionType.getMessage();
    }
    @Override
    public String toString() {
        return "DataNotFoundException{" +
                "errorCode=" + notFoundExceptionType.getErrorCode() +
                ", detail='" + detail + '\'' +
                '}';
    }
}
