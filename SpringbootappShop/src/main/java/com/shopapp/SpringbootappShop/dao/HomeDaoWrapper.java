package com.shopapp.SpringbootappShop.dao;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.entities.CustomerEntity;
import com.shopapp.SpringbootappShop.entities.ManagerPendingEntity;
import com.shopapp.SpringbootappShop.entities.UserEntity;

import jakarta.transaction.Transactional;

@Repository
public class HomeDaoWrapper {
	@Autowired
	DaoCustomer daoCustomer;
	@Autowired
	DaoUser daoUser;
	@Autowired
	DaoManagerPending daoManagerPending;
	
	@Transactional
	public void registerCustomer(CustomerBean customerBean) {
		CustomerEntity customerEntity = new CustomerEntity();
		BeanUtils.copyProperties(customerBean,customerEntity);
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(customerEntity.getCustomerName());
		userEntity.setUserPassword(customerEntity.getCustomerPassword());
		userEntity.setUserRole("CUSTOMER");
		UserEntity savedUserEntity = daoUser.save(userEntity);
		customerEntity.setUser(savedUserEntity);
		daoCustomer.save(customerEntity);
	}
	
	public void registerManagerPending(ManagerPendingBean managerPendingBean) {
		ManagerPendingEntity managerPendingEntity = new ManagerPendingEntity();
		BeanUtils.copyProperties(managerPendingBean,managerPendingEntity);
		daoManagerPending.save(managerPendingEntity);		
	}

}
