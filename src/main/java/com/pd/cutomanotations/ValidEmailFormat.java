package com.pd.cutomanotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = EmailFormatValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmailFormat {
    String message() default "Invalid email format. It must follow the pattern numbers@letters.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

