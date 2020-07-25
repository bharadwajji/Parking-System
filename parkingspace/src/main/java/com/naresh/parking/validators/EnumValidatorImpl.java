package com.naresh.parking.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import com.naresh.parkingspace.annotations.EnumValidator;

@Component
public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, Enum<?>> {
    private Pattern pattern;
 
    @Override
    public void initialize(EnumValidator annotation) {
        try {
        	pattern = Pattern.compile(annotation.regexp());
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("Given regex is invalid", e);
        }
    }
 
    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
 
        Matcher m = pattern.matcher(value.name());
        return m.matches();
    }
}