package com.shopapp.SpringbootappShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.dao.HomeDaoWrapper;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	private HomeDaoWrapper homeDaoWrapper;
	@Override
	public void registerCustomer(CustomerBean customerBean) {
		// TODO Auto-generated method stub
		homeDaoWrapper.registerCustomer(customerBean);	
	}
	
	@Override
	public void registerManagerPending(ManagerPendingBean managerPendingBean) {
		// TODO Auto-generated method stub
		homeDaoWrapper.registerManagerPending(managerPendingBean);
		
	}

}
