package com.pocspringboot.validation.annotations;


import com.pocspringboot.validation.constraints.MinMaxStrategyTypeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MinMaxStrategyTypeValidator.class)
public @interface ValidMinMaxStrategyType {

    String message() default "Invalid MinMaxStrategyType";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}