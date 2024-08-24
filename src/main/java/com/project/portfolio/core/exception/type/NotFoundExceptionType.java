package com.project.portfolio.core.exception.type;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotFoundExceptionType {
    GENERIC_EXCEPTION(1, "Bilinmeyen hata"),
    USER_NOT_FOUND(1001, "Kullanıcı bulunamadı"),
    SOCIAL_MEDIA_NOT_FOUND(1002,"Sosyal Medya bulunamadı"),
    SKILL_NOT_FOUND(1003,"Yetenek bulunamadı"),
    CERTIFICATE_NOT_FOUND(1004,"Sertifika bulunamadı"),
    CONTACT_NOT_FOUND(1005,"İletişim bilgisi bulunamadı"),
    COURSE_NOT_FOUND(1006,"Kurs bulunamadı"),
    EDUCATION_NOT_FOUND(1007,"Eğitim bulunamadı"),
    EXPERIENCE_NOT_FOUND(1008,"Deneyim bulunamadı"),
    HOBBY_NOT_FOUND(1009,"Hobi bulunamadı"),
    LANGUAGE_NOT_FOUND(1010,"Dil bulunamadı"),
    POST_NOT_FOUND(1011,"Gönderi bulunamadı"),
    PROJECT_NOT_FOUND(1012,"Proje bulunamadı"),
    REFERENCE_NOT_FOUND(1013,"Referans bulunamadı"),
    RESUME_NOT_FOUND(1014,"Özgeçmiş bulunamadı"),
    ;

    private final Integer errorCode;
    private final String message;
}
