package com.project.portfolio.core.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InvalidImageExceptionType {

    INVALID_IMAGE_FORMAT(5000,"Geçersiz resim formatı."),
    INVALID_MIME_TYPE(5001, "Geçersiz mime tipi."),
    ;

    private final Integer errorCode;
    private final String message;
}
