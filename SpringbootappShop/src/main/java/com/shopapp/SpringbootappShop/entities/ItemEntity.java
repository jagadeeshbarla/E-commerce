package com.shopapp.SpringbootappShop.entities;

import java.util.Arrays;

import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data 
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer itemid;
	private String itemName;
	private String itemBrand;
	private String itemDescription;
	private Double itemPrice;
	private Integer itemQuantity;
	private String imageName;
	private String imageType;
	@Lob
	private byte[] imageDate;
		
}
