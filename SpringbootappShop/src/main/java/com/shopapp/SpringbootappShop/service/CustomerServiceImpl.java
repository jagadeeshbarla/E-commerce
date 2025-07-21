package com.shopapp.SpringbootappShop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopapp.SpringbootappShop.beans.ItemBean;
import com.shopapp.SpringbootappShop.dao.CustomerDaoWrapper;
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDaoWrapper customerDaoWrapper;
	
	@Override
	public List<ItemBean> getAllItems() {
		return customerDaoWrapper.getAllItems();
	}

	@Override
	public ItemBean getItemById(Integer itemid) {
		return customerDaoWrapper.getItemByInteger(itemid);
	}

}
