package com.shopapp.SpringbootappShop.entities;

import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ManagerPending")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class ManagerPendingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer managerPendingid;
	private String managerPendingName;
	private String managerPendingPassword;
	private String managerPendingEmail;
	
}
