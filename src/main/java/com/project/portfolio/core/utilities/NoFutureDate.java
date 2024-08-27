package com.project.portfolio.core.utilities;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NoFutureDateValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface NoFutureDate {
    String message() default "Tarih bugünden sonrası olamaz.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
