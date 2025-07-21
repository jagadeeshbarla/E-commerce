package com.shopapp.SpringbootappShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.service.HomeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping("/loadRegisterCustomer")
	public ModelAndView userRegistration() {
		return new ModelAndView("registerCustomer","customerBean",new CustomerBean());
	}
	@RequestMapping("/registerCustomer")
	public ModelAndView processCustomerRegistration(@ModelAttribute("customerBean") @Valid CustomerBean customerBean,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		
		if(result.hasErrors()) {
			modelAndView.setViewName("registerCustomer");
		}
		else {
			homeService.registerCustomer(customerBean);
			modelAndView.addObject("customerName" , customerBean.getCustomerName());
			modelAndView.setViewName("CustomerregisteredSucessfull");
		}
		return modelAndView;
	}
	
	
	@RequestMapping("/loadRegisterManagerPending")
	public ModelAndView ManagerPendingRegistration() {
		return new ModelAndView("registerManagerPending","managerPendingBean",new ManagerPendingBean());
	}
	@RequestMapping("/registerManagerPending")
	public ModelAndView managerRegister(@ModelAttribute("managerPendingBean") @Valid ManagerPendingBean managerPendingBean,BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();		
		if(result.hasErrors()) {
			modelAndView.setViewName("registerManagerPending");
		}
		else {
			homeService.registerManagerPending(managerPendingBean);
			modelAndView.addObject("managerName" , managerPendingBean.getManagerPendingName());
			modelAndView.addObject("managerEmail" , managerPendingBean.getManagerPendingEmail());
			modelAndView.setViewName("ManagerPendingregisteredSucessfull");
		}
		return modelAndView;		
	}

	
	@RequestMapping("/GotoCustomer")
	public String gotoCustomerPage() {
		return "Customer";
	}
	@RequestMapping("/GotoManager")
	public String gotoManagerPage() {
		return "Manager";
	}
	@RequestMapping("/GotoAdmin")
	public String gotoAdminPage() {
		return "Admin";
	}
	@RequestMapping("/homepage")
	public String homePage() {
		return "homepagejsp";
	}
	
	

}
