package Validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= {EmailValidationRequirement.class})
public @interface EmailValidation {
	public String message() default "Please provide a valid email address";
	public Class<?>[]groups() default{};
	public Class<?extends Payload>[] payload() default{};

}
