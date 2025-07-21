package com.shopapp.SpringbootappShop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ManagerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.entities.ManagerEntity;
import com.shopapp.SpringbootappShop.entities.ManagerPendingEntity;
import com.shopapp.SpringbootappShop.dao.AdminDaoWrapper;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDaoWrapper adminDaoWrapper;
	@Autowired 
	EmailService emailService;
	
	
	@Override
	public List<ManagerPendingBean> getAllManagerPending() {
		return adminDaoWrapper.getAllManagerPending();
	}
	@Override
	public void removeManagerPending(Integer ManagerPendingBeanid,String managerPendingBeanEmail ,String managerPendingBeanName) {
		String to = managerPendingBeanEmail;
		String subject = "Job Status at JAGGU'S shop : NotSelected";
		String body = "Hi "+ managerPendingBeanName +",\nUnfortunately you are not selected for the job you have applied at JAGGU'S shop.\nAll the best for your future.\nWith regards,\nTEAM JAGGU'S SHOP";
		emailService.sendEmail(to, subject, body);

		adminDaoWrapper.removeManagerPending(ManagerPendingBeanid);
	}
	@Override
	public void registerManager(Integer managerPendingBeanid,String managerPendingBeanEmail ,String managerPendingBeanName) {
		ManagerEntity managerEntity = new ManagerEntity();
		ManagerPendingEntity managerPendingEntity = adminDaoWrapper.getManagerPending(managerPendingBeanid);
		managerEntity.setManagerName(managerPendingEntity.getManagerPendingName());
		managerEntity.setManagerPassword(managerPendingEntity.getManagerPendingPassword());
		managerEntity.setManagerEmail(managerPendingEntity.getManagerPendingEmail());
		
		String to = managerPendingBeanEmail;
		String subject = "Job Status at JAGGU'S shop : Selected";
		String body = "Hi "+ managerPendingBeanName +",\nCongratulation you are selected for the job you have applied at JAGGU'S shop.Your onboarding process will be started soon.\nAll the best for your future.\nWith regards,\nTEAM JAGGU'S SHOP";
		emailService.sendEmail(to, subject, body);
		
		adminDaoWrapper.removeManagerPending(managerPendingBeanid);
		adminDaoWrapper.registerManager(managerEntity);		
	}
	@Override
	public List<ManagerBean> getAllManager() {
		return adminDaoWrapper.getAllManager();
	}
	@Override
	public List<CustomerBean> getAllCustomer() {
		return adminDaoWrapper.getAllCustomer();
	}
	@Override
	public void removeManager(Integer managerBeanid,String managerBeanEmail , String managerBeanName) {
		String to = managerBeanEmail;
		String subject = "Access removal at JAGGU'S shop as a manager";
		String body = "Hi "+ managerBeanName +",\nWe are sorry to inform you that we have removed your access at JAGGU'S shop due to company regulations.\nAll the best for your future.\nWith regards,\nTEAM JAGGU'S SHOP";
		emailService.sendEmail(to, subject, body);
		adminDaoWrapper.removeManager(managerBeanid);
		
	}
	@Override
	public void removeCustomer(Integer customerBeanid,String customerBeanEmail , String customerBeanName) {
		String to = customerBeanEmail;
		String subject = "Access removal at JAGGU'S shop as a customer.";
		String body = "Hi "+ customerBeanName +",\nWe are sorry to inform you that we have removed your access at JAGGU'S shop due to company regulations.\nWith regards,\nTEAM JAGGU'S SHOP";
		emailService.sendEmail(to, subject, body);
		adminDaoWrapper.removeCustomer(customerBeanid);
		
	}

}
