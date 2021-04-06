package com.poc.exception_handling.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements
        ConstraintValidator<NameValidationConstraint, String> {

    private static final String ALPHA_NAME_INTERNATIONAL_REGEX = "^(?U)[\\p{Alpha}\\-'. ]+";

    @Override
    public void initialize(NameValidationConstraint name) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext cxt) {
        return name != null &&
                !name.isEmpty() &&
                name.matches(ALPHA_NAME_INTERNATIONAL_REGEX);
    }

}


