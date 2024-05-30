package com.pd.cutomanotations;

import com.pd.constants.Constants;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailFormatValidator implements ConstraintValidator<ValidEmailFormat, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email == null) {
            return false; 
        }
        return email.matches(Constants.EMPLOYEE_EMAIL_PATTERN);
    }
}
