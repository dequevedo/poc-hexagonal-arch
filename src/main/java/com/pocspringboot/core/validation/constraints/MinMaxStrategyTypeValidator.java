package com.pocspringboot.core.validation.constraints;

import com.pocspringboot.core.enumeration.MinMaxStrategyType;
import com.pocspringboot.core.validation.annotations.ValidMinMaxStrategyType;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

@Component
public class MinMaxStrategyTypeValidator implements ConstraintValidator<ValidMinMaxStrategyType, String> {

    @Override
    public void initialize(ValidMinMaxStrategyType constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return Arrays.asList(MinMaxStrategyType.values()).contains(MinMaxStrategyType.fromName(value));
    }
}
