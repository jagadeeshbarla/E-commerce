package Validations;

import org.springframework.beans.factory.annotation.Autowired;

import com.shopapp.SpringbootappShop.dao.DaoUser;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidationRequirement implements ConstraintValidator<NameValidation,String> {
	
	@Autowired
	DaoUser daoUser;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return (daoUser.existsByUsername(value))?false:true;
	}

}
