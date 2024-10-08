package com.project.portfolio.core.exception;

import com.project.portfolio.core.exception.type.FileExceptionType;
import lombok.Getter;

@Getter
public class FileException extends RuntimeException{
    private final FileExceptionType fileExceptionType;
    private final String detail;

    public FileException(FileExceptionType fileExceptionType, String detail) {
        super(fileExceptionType.getMessage());
        this.fileExceptionType = fileExceptionType;
        this.detail = detail;
    }

    public FileException(FileExceptionType fileExceptionType) {
        super(fileExceptionType.getMessage());
        this.fileExceptionType = fileExceptionType;
        this.detail = fileExceptionType.getMessage();
    }
    @Override
    public String toString() {
        return "FileException{" +
                "errorCode=" + fileExceptionType.getErrorCode() +
                ", detail='" + detail + '\'' +
                '}';
    }
}
