package com.project.portfolio.core.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlreadyExistsExceptionType {
    USER_ALREADY_EXISTS(2001, "Kullanıcı zaten mevcut"),
    SOCIAL_MEDIA_EXISTS(2002,"Sosyal Medya zaten mevcut"),
    SKILL_EXISTS(2003,"Yetenek zaten mevcut"),
    CERTIFICATE_EXISTS(2004,"Sertifika zaten mevcut"),
    CONTACT_EXISTS(2005,"İletişim bilgisi zaten mevcut"),
    COURSE_EXISTS(2006,"Kurs zaten mevcut"),
    EDUCATION_EXISTS(2007,"Eğitim zaten mevcut"),
    EXPERIENCE_EXISTS(2008,"Deneyim zaten mevcut"),
    HOBBY_EXISTS(2009,"Hobi zaten mevcut"),
    LANGUAGE_EXISTS(2010,"Dil zaten mevcut"),
    POST_EXISTS(2011,"Gönderi zaten mevcut"),
    PROJECT_EXISTS(2012,"Proje zaten mevcut"),
    REFERENCE_EXISTS(2013,"Referans zaten mevcut"),
    RESUME_EXISTS(2014,"Özgeçmiş zaten mevcut");
    private final Integer errorCode;
    private final String message;
}
