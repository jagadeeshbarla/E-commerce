package Validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= {NameValidationRequirement.class})
public @interface NameValidation {
	public String message() default "Name should be unique";
	public Class<?>[]groups() default{};
	public Class<?extends Payload>[] payload() default{};
}
