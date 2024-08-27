package com.project.portfolio.core.utilities;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class NoFutureDateValidator implements ConstraintValidator<NoFutureDate, LocalDate> {

    @Override
    public void initialize(NoFutureDate constraintAnnotation) {
        // Anotasyon başlangıcında yapılacak işlemler.
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Null değer geçerli kabul edilebilir, bu ayarlanabilir.
        }
        return !value.isAfter(LocalDate.now()); // Bugünden sonra tarih girişi engellenir.
    }
}

