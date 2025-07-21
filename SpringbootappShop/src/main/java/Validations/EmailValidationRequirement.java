package Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailValidationRequirement implements ConstraintValidator<EmailValidation,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		return value.matches(emailRegex);
	}

}
