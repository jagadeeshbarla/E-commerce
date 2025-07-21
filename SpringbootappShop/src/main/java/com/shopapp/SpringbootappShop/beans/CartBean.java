package com.shopapp.SpringbootappShop.beans;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class CartBean {
	
	private Integer cartId;
    private CustomerBean customer;
    private List<CartItemBean> items;

}
