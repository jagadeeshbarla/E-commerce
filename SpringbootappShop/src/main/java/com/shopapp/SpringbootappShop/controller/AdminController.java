package com.shopapp.SpringbootappShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.shopapp.SpringbootappShop.beans.ManagerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.service.AdminService;
import com.shopapp.SpringbootappShop.service.EmailService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	
	@RequestMapping("/home")
	public String gotoHomePage() {
		return "home";
	}
	
	@RequestMapping("/allManager")
	public ModelAndView allManagerPage() {
		return new ModelAndView("allManager", "managerList", adminService.getAllManager());
	}
	@RequestMapping("/removeManager")
	public RedirectView removeManagerPage(@RequestParam Integer managerBeanid , @RequestParam String managerBeanEmail , @RequestParam String managerBeanName) {	
		adminService.removeManager(managerBeanid,managerBeanEmail,managerBeanName);
		return new RedirectView("/admin/allManager"); 
	}
	
	@RequestMapping("/allCustomer")
	public ModelAndView allCustomerPage() throws Exception {
		return new ModelAndView("allCustomer", "customerList", adminService.getAllCustomer()); 
	}
	@RequestMapping("/removeCustomer")
	public RedirectView removeCustomerPage(@RequestParam Integer customerBeanid , @RequestParam String customerBeanEmail , @RequestParam String customerBeanName) {
		adminService.removeCustomer(customerBeanid,customerBeanEmail,customerBeanName);
		return new RedirectView("/admin/allCustomer");
	}
	
	@RequestMapping("/allManagerPending")
	public ModelAndView allManagerPendingPage() {
		return new ModelAndView("allManagerPending", "managerPendingList", adminService.getAllManagerPending());
    }
	@RequestMapping("/approveManagerRequest")
	public RedirectView approveManagerRequest(@RequestParam Integer managerPendingBeanid , @RequestParam String managerPendingBeanEmail , @RequestParam String managerPendingBeanName) {
		adminService.registerManager(managerPendingBeanid, managerPendingBeanEmail ,managerPendingBeanName);
		return new RedirectView("/admin/allManagerPending"); 
	}
	@RequestMapping("/declineManagerRequest")
	public RedirectView declineManagerRequest(@RequestParam Integer managerPendingBeanid , @RequestParam String managerPendingBeanEmail , @RequestParam String managerPendingBeanName) {
		adminService.removeManagerPending(managerPendingBeanid, managerPendingBeanEmail , managerPendingBeanName);
		return new RedirectView("/admin/allManagerPending");
	}
	
	@RequestMapping("/error")
	public ModelAndView errorHandeling() {
    	return new ModelAndView("error");
	}
    @ExceptionHandler(value = Exception.class)
	public ModelAndView hadleAllExceptions(Exception exception) {
    	return new ModelAndView("ExceptionPage");
	}

}
