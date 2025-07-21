package com.shopapp.SpringbootappShop.service;

import java.util.List;

import com.shopapp.SpringbootappShop.beans.ItemBean;

public interface CustomerService {
	public List<ItemBean> getAllItems();

	public ItemBean getItemById(Integer itemid);

}
