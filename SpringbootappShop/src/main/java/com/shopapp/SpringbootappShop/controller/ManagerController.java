package com.shopapp.SpringbootappShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.shopapp.SpringbootappShop.beans.ItemBean;
import com.shopapp.SpringbootappShop.service.ManagerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	ManagerService managerService ;
	
	@RequestMapping("/addNewProduct")
	public ModelAndView addNewProduct() {
		return new ModelAndView("addNewProduct","itemBean",new ItemBean());
	}
	
	@RequestMapping("/registerNewProduct")
	public ModelAndView registerNewProduct(@Valid @ModelAttribute("itemBean") ItemBean itemBean,BindingResult result,@RequestParam("image") MultipartFile image) {
		ModelAndView modelAndView = new ModelAndView();
		if(result.hasErrors()) {
			modelAndView.setViewName("addNewProduct");
		}
		else {
			managerService.addproduct(itemBean,image);
			modelAndView.setViewName("NewitemaddedSucessfull");
		}
		return modelAndView;
	}
	
	@RequestMapping("/inventoryDetails")
	public ModelAndView viewInventory() {
		return new ModelAndView("InventoryDetails", "itemList", managerService.getAllItems());	
	}
	
	@RequestMapping("/removeProduct")
	public RedirectView removeProduct(@RequestParam Integer productBeanid ) {
		managerService.removeProduct(productBeanid);
		return new RedirectView("/manager/inventoryDetails");
	}
	
	@RequestMapping("/getUpdatedValues")
	public RedirectView getUpdatedValues(@RequestParam Integer itemBeanid,@RequestParam Double newPrice ,@RequestParam Integer newQuantity) {
		managerService.updateItemDetails(itemBeanid,newPrice,newQuantity);
		return new RedirectView("/manager/inventoryDetails");
	}
	
	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam Integer productBeanid ) {
		return new ModelAndView("updateProduct", "itemBean", managerService.getItemById(productBeanid));
	}
	
	@GetMapping("/getimage/{itemid}")
    public ResponseEntity<byte[]> getImage(@PathVariable("itemid") Integer itemid) {
    	ItemBean item = managerService.getItemById(itemid);
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
 