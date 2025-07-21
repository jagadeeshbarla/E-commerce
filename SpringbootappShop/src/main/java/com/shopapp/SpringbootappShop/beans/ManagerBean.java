package com.shopapp.SpringbootappShop.beans;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data 
@NoArgsConstructor
@AllArgsConstructor
public class ManagerBean {
	
	private Integer managerid;
	private String managerName;
	private String managerPassword;
	private String managerEmail;
	
	

}
