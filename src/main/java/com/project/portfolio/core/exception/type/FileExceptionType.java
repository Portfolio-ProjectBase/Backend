package com.project.portfolio.core.exception.type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum FileExceptionType {
    USER_FILE_ERROR(4001, "Kullanıcı dosyası hatası"),
    SOCIAL_MEDIA_FILE_ERROR(4002, "Sosyal Medya dosyası hatası"),
    SKILL_FILE_ERROR(4003, "Yetenek dosyası hatası"),
    CERTIFICATE_FILE_ERROR(4004, "Sertifika dosyası hatası"),
    POST_FILE_ERROR(4005, "Gönderi dosyası hatası"),
    PROJECT_FILE_ERROR(4006, "Proje dosyası hatası"),
    RESUME_FILE_ERROR(4007, "Özgeçmiş dosyası hatası"),
    ;

    private final Integer errorCode;
    private final String message;
}