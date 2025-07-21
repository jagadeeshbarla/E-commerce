package com.shopapp.SpringbootappShop.service;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;

public interface HomeService {
	
	public void registerCustomer(CustomerBean customerBean);
	public void registerManagerPending(ManagerPendingBean managerPendingBean);

}
