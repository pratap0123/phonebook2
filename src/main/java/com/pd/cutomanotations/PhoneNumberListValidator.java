package com.pd.cutomanotations;

import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberListValidator implements ConstraintValidator<ValidPhoneNumber, List<String>> {

	@Override
	public boolean isValid(List<String> phoneNumbers, ConstraintValidatorContext context) {
		if (phoneNumbers == null) {
			return true; 
		}
		for (String phoneNumber : phoneNumbers) {
			if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
				return false;
			}
		}
		return true;
	}
}
