package com.shopapp.SpringbootappShop.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ManagerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;



public interface AdminService {

	List<ManagerPendingBean> getAllManagerPending();
	List<ManagerBean> getAllManager();
	List<CustomerBean> getAllCustomer();
	
	void removeManagerPending(Integer managerPendingBeanid,String managerPendingBeanEmail , String managerPendingBeanName);
	void removeManager(Integer ManagerBeanid,String managerBeanEmail,String managerBeanName);
	void removeCustomer(Integer customerBeanid,String customerBeanEmail , String customerBeanName);
	void registerManager(Integer managerPendingBeanid,String managerPendingBeanEmail , String managerPendingBeanName);
	

}
