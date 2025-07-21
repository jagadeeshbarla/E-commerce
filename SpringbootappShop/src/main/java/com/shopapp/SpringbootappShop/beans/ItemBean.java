package com.shopapp.SpringbootappShop.beans;

import java.util.Arrays;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class ItemBean {
	private Integer itemid;
	@NotEmpty(message="Item name Shouldn't be empty")
	private String itemName;
	@NotEmpty(message="Item brand Shouldn't be empty")
	private String itemBrand;
	private String itemDescription;
	@NotNull
	private Double itemPrice;
	@NotNull
	private Integer itemQuantity;
	
	private String imageName;
	private String imageType;
	private byte[] imageDate;
	
	
}
