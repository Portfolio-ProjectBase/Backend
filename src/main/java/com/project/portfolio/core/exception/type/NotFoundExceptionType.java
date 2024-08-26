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

    USER_LIST_NOT_FOUND(1015, "Kullanıcı listesi bulunamadı"),
    SOCIAL_MEDIA_LIST_NOT_FOUND(1016, "Sosyal Medya listesi bulunamadı"),
    SKILL_LIST_NOT_FOUND(1017, "Yetenek listesi bulunamadı"),
    CERTIFICATE_LIST_NOT_FOUND(1018, "Sertifika listesi bulunamadı"),
    CONTACT_LIST_NOT_FOUND(1019, "İletişim bilgisi listesi bulunamadı"),
    COURSE_LIST_NOT_FOUND(1020, "Kurs listesi bulunamadı"),
    EDUCATION_LIST_NOT_FOUND(1021, "Eğitim listesi bulunamadı"),
    EXPERIENCE_LIST_NOT_FOUND(1022, "Deneyim listesi bulunamadı"),
    HOBBY_LIST_NOT_FOUND(1023, "Hobi listesi bulunamadı"),
    LANGUAGE_LIST_NOT_FOUND(1024, "Dil listesi bulunamadı"),
    POST_LIST_NOT_FOUND(1025, "Gönderi listesi bulunamadı"),
    PROJECT_LIST_NOT_FOUND(1026, "Proje listesi bulunamadı"),
    REFERENCE_LIST_NOT_FOUND(1027, "Referans listesi bulunamadı"),
    RESUME_LIST_NOT_FOUND(1028, "Özgeçmiş listesi bulunamadı");

    private final Integer errorCode;
    private final String message;
}
