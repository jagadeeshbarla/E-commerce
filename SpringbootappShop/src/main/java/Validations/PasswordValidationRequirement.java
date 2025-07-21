package Validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidationRequirement implements ConstraintValidator<PasswordValidation,String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		//Password length should be greater than 7 and it should have atleast one number , one special Character ,one capital letter and one small letter
		String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#$%^&*(),.?\":{}|<>]{8,}$";
		return value.matches(passwordRegex);
	}

}
