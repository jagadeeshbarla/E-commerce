package com.shopapp.SpringbootappShop.entities;

import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Manager")
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class ManagerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer managerid;
	private String managerName;
	private String managerPassword;
	private String managerEmail;
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "user_id", referencedColumnName = "userid")
	private UserEntity user;
}
