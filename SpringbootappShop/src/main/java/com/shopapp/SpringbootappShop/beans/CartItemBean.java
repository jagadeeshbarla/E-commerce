package com.shopapp.SpringbootappShop.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CartItemBean {
	
	 private Long id;
	 private ItemBean item;
	 private Integer quantity;
	 private CartBean cart;

}
