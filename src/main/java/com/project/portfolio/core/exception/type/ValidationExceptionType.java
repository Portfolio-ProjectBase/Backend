package com.project.portfolio.core.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum ValidationExceptionType {
    VALIDATION_EXCEPTION(3000, "Girilen bilgiler uygun deðil"),
    USER_VALIDATION_FAILED(3001, "Kullanıcı doğrulaması başarısız"),
    SOCIAL_MEDIA_VALIDATION_FAILED(3002,"Sosyal Medya doğrulaması başarısız"),
    SKILL_VALIDATION_FAILED(3003,"Yetenek doğrulaması başarısız"),
    CERTIFICATE_VALIDATION_FAILED(3004,"Sertifika doğrulaması başarısız"),
    CONTACT_VALIDATION_FAILED(3005,"İletişim bilgisi doğrulaması başarısız"),
    COURSE_VALIDATION_FAILED(3006,"Kurs doğrulaması başarısız"),
    EDUCATION_VALIDATION_FAILED(3007,"Eğitim doğrulaması başarısız"),
    EXPERIENCE_VALIDATION_FAILED(3008,"Deneyim doğrulaması başarısız"),
    HOBBY_VALIDATION_FAILED(3009,"Hobi doğrulaması başarısız"),
    LANGUAGE_VALIDATION_FAILED(3010,"Dil doğrulaması başarısız"),
    POST_VALIDATION_FAILED(3011,"Gönderi doğrulaması başarısız"),
    PROJECT_VALIDATION_FAILED(3012,"Proje doğrulaması başarısız"),
    REFERENCE_VALIDATION_FAILED(3013,"Referans doğrulaması başarısız"),
    RESUME_VALIDATION_FAILED(3014,"Özgeçmiş doğrulaması başarısız"),
    DOTCOM_VALIDATION_FAILED(3015,"Site linki '.com' ile bitmelidir."),
    IMAGE_VALIDATION_FAILED(3016,"Resim boş geçilemez."),
    ;

    private final Integer errorCode;
    private final String message;
}
