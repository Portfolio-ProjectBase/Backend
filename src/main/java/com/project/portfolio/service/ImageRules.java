package com.project.portfolio.service;

import com.project.portfolio.core.exception.InvalidImageException;
import com.project.portfolio.core.utilities.ImageUtils;
import org.springframework.stereotype.Component;

import static com.project.portfolio.core.exception.type.InvalidImageExceptionType.INVALID_IMAGE_FORMAT;
import static com.project.portfolio.core.exception.type.InvalidImageExceptionType.INVALID_MIME_TYPE;

@Component
public class ImageRules {

    public static void validateImage(byte[] image) {
        /*if (image == null || image.length == 0) {
            throw new InvalidImageException(INVALID_IMAGE_FORMAT);
        }*/
        try {
            // Resmin MIME tipini kontrol et
            String mimeType = ImageUtils.getImageMimeType(image);
            if (mimeType.equals("application/octet-stream")) {
                throw new InvalidImageException(INVALID_MIME_TYPE);
            }
        } catch (Exception e) {
            throw new InvalidImageException(INVALID_IMAGE_FORMAT, e.getMessage());
        }
    }

    public static void validateMimeType(String mimeType) {
        if (mimeType == null || mimeType.isEmpty()) {
            throw new InvalidImageException(INVALID_MIME_TYPE);
        }
        if (!(mimeType.equals("image/png") || mimeType.equals("image/jpeg") || mimeType.equals("image/gif"))) {
            throw new InvalidImageException(INVALID_MIME_TYPE);
        }
    }
}
