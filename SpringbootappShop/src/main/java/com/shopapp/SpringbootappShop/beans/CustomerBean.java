package com.shopapp.SpringbootappShop.beans;

import com.shopapp.SpringbootappShop.entities.CartEntity;
import com.shopapp.SpringbootappShop.entities.UserEntity;

import Validations.EmailValidation;
import Validations.NameValidation;
import Validations.PasswordValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CustomerBean {

	private Integer customerid;
	@NameValidation
	@NotEmpty(message="Name Shouldn't be empty")
	private String customerName;
	@PasswordValidation
	private String customerPassword;
	@EmailValidation
	private String customerEmail;
	private String customerRole = "Customer";
	@NotNull
	private Double balance;
	private UserEntity user;
	private CartEntity cart;
	

}
