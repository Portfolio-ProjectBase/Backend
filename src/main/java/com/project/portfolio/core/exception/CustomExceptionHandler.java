package com.project.portfolio.core.exception;

import com.project.portfolio.core.exception.response.ErrorResponse;
import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import com.project.portfolio.core.exception.type.ValidationExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleException(Exception e) {
        return new ErrorResponse(NotFoundExceptionType.GENERIC_EXCEPTION, Collections.singletonList(e.getMessage()));
    }

    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleDataNotFoundException(DataNotFoundException e) {
        return new ErrorResponse(e.getNotFoundExceptionType(), Collections.singletonList(e.getDetail()));
    }

    @ExceptionHandler(FileException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse handleFileException(FileException e) {
        return new ErrorResponse(e.getFileExceptionType(), Collections.singletonList(e.getDetail()));
    }

    @ExceptionHandler(AlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleAlreadyExistsException(AlreadyExistsException e) {
        return new ErrorResponse(e.getAlreadyExistsExceptionType(), Collections.singletonList(e.getDetail()));
    }


    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationException(ValidationException e) {
        return new ErrorResponse(e.getValidationExceptionType(), Collections.singletonList(e.getDetail()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        List<String> validationErrors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            validationErrors.add(fieldName + ": " + errorMessage);
        });

        ValidationExceptionType validationExceptionType = ValidationExceptionType.VALIDATION_EXCEPTION;
        ValidationException validationException = new ValidationException(validationExceptionType, "Validation error");
        validationException.setDetail(validationErrors.toString());

        ErrorResponse errorResponse = new ErrorResponse(validationExceptionType, Collections.singletonList("Validation error"));
        errorResponse.setDetails(validationErrors);

        return errorResponse;
    }
}
