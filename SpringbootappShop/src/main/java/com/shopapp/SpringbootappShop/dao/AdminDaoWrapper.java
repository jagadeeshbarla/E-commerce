package com.shopapp.SpringbootappShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ManagerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.entities.CustomerEntity;
import com.shopapp.SpringbootappShop.entities.ManagerEntity;
import com.shopapp.SpringbootappShop.entities.ManagerPendingEntity;
import com.shopapp.SpringbootappShop.entities.UserEntity;


@Repository
public class AdminDaoWrapper {
	
	@Autowired
	DaoManagerPending daoManagerPending;
	@Autowired
	DaoManager daoManager;
	@Autowired
	DaoCustomer daoCustomer;
	@Autowired
	DaoUser daoUser;
	
	public List<ManagerPendingBean> getAllManagerPending(){
		List<ManagerPendingEntity> managerPendingEntityList= daoManagerPending.findAll();
		List<ManagerPendingBean> managerPendingBeanList = new ArrayList<ManagerPendingBean>();
		
		for( ManagerPendingEntity managerPendingEntity : managerPendingEntityList) {
			ManagerPendingBean managerPendingBean = new ManagerPendingBean();
			BeanUtils.copyProperties(managerPendingEntity, managerPendingBean);
			managerPendingBeanList.add(managerPendingBean);			
		}
		return managerPendingBeanList;
	}
	public void removeManagerPending(Integer ManagerPendingBeanid) {
		daoManagerPending.deleteById(ManagerPendingBeanid);
	}
	public ManagerPendingEntity getManagerPending(Integer managerPendingBeanid) {
		return daoManagerPending.findByManagerPendingid(managerPendingBeanid);		
	}
	public void registerManager(ManagerEntity managerEntity) {
		
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(managerEntity.getManagerName());
		userEntity.setUserPassword(managerEntity.getManagerPassword());
		userEntity.setUserRole("MANAGER");
		UserEntity savedUserEntity = daoUser.save(userEntity);
		managerEntity.setUser(savedUserEntity);
		daoManager.save(managerEntity);
	}
	public List<ManagerBean> getAllManager(){
		List<ManagerBean> managerBeanList = new ArrayList<ManagerBean>();
		for(ManagerEntity managerEntity : daoManager.findAll()) {
			ManagerBean managerBean = new ManagerBean();
			BeanUtils.copyProperties(managerEntity, managerBean);
			managerBeanList.add(managerBean);				
		}
		return managerBeanList;		
	}
	public List<CustomerBean> getAllCustomer() {
		List<CustomerBean> customerBeanList = new ArrayList<CustomerBean>();
		for(CustomerEntity customerEntity : daoCustomer.findAll()) {
			CustomerBean customerBean = new CustomerBean();
			BeanUtils.copyProperties(customerEntity, customerBean);
			customerBeanList.add(customerBean);			
		}
		return customerBeanList;
		
	}
	public void removeManager(Integer managerBeanid) {
		daoManager.deleteById(managerBeanid);		
	}
	public void removeCustomer(Integer customerBeanid) {
		daoCustomer.deleteById(customerBeanid);		
	}

}
