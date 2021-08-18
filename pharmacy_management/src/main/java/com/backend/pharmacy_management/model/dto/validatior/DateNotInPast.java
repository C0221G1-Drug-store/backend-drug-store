package com.backend.pharmacy_management.model.dto.validatior;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DatePastValidator.class)
@Documented
public @interface DateNotInPast {
    String message() default "the day is not in the past";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
class DatePastValidator implements ConstraintValidator<DateNotInPast, LocalDate> {

    @Override
    public void initialize(DateNotInPast constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        try {
            LocalDate current = LocalDate.now();
            return (value.isEqual(current) || value.isAfter(current)) ;
        }catch(DateTimeParseException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
