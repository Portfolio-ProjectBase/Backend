package com.project.portfolio.core.exception.response;

import com.project.portfolio.core.exception.type.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    private int errorCode;

    private LocalDateTime timestamp = LocalDateTime.now();
    private List<String> details;

    //bilgi: CUSTOM Exception Handler ile error response dönüyoruz.
    public ErrorResponse(NotFoundExceptionType notFoundExceptionType, List<String> details) {
        this.errorCode = notFoundExceptionType.getErrorCode();
        this.details = details;
    }

    public ErrorResponse(AlreadyExistsExceptionType alreadyExistsExceptionType, List<String> details) {
        this.errorCode = alreadyExistsExceptionType.getErrorCode();
        this.details = details;
    }

    public ErrorResponse(ValidationExceptionType validationExceptionType, List<String> details) {
        this.errorCode = validationExceptionType.getErrorCode();
        this.details = details;
    }

    public ErrorResponse(FileExceptionType fileExceptionType, List<String> details) {
        this.errorCode = fileExceptionType.getErrorCode();
        this.details = details;
    }

    public ErrorResponse(InvalidImageExceptionType invalidImageExceptionType, List<String> details) {
        this.errorCode = invalidImageExceptionType.getErrorCode();
        this.details = details;
    }
}