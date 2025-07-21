package Validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy= {PasswordValidationRequirement.class})
public @interface PasswordValidation {
	
	public String message() default "Password length should be greater than 7 and it should have atleast one number , one special Character ,one capital letter and one small letter";
	public Class<?>[]groups() default{};
	public Class<?extends Payload>[] payload() default{};
}
