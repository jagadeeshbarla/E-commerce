package com.shopapp.SpringbootappShop.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shopapp.SpringbootappShop.beans.ItemBean;
import com.shopapp.SpringbootappShop.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	
	@RequestMapping("/addCash")
	public String gotoAddCashPage() {
		return "addCash";
	}
	
	@RequestMapping("/bookOrders")
	public ModelAndView gotoBookOrdersPage() {
		return new ModelAndView("shopingPage", "itemList", customerService.getAllItems());
	}
	@GetMapping("/getimage/{itemid}")
    public ResponseEntity<byte[]> getImage(@PathVariable("itemid") Integer itemid) {
    	
    	ItemBean item = customerService.getItemById(itemid);
        if (item != null && item.getImageDate() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.valueOf(item.getImageType()))
                    .body(item.getImageDate());
        }
        return ResponseEntity.notFound().build();
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
