package com.pocspringboot.validation.constraints;

import com.pocspringboot.enumeration.MinMaxStrategyType;
import com.pocspringboot.validation.annotations.ValidMinMaxStrategyType;
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
