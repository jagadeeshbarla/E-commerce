package com.shopapp.SpringbootappShop.beans;

import org.springframework.beans.factory.annotation.Value;

import Validations.EmailValidation;
import Validations.NameValidation;
import Validations.PasswordValidation;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class ManagerPendingBean {
	
	private Integer managerPendingid;
	@NameValidation
	@NotEmpty(message="Name Shouldn't be empty")
	private String managerPendingName;
	@PasswordValidation // Custom Validation
	private String managerPendingPassword;
	@EmailValidation
	private String managerPendingEmail;
	
}
