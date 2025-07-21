package com.shopapp.SpringbootappShop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.shopapp.SpringbootappShop.beans.ItemBean;


public interface ManagerService {
	public void addproduct(ItemBean itemBean ,MultipartFile image);
	public List<ItemBean> getAllItems();
	public ItemBean getItemById(Integer itemid);
	public void removeProduct(Integer itemid);
	public void updateItemDetails(Integer itemBeanid, Double newPrice , Integer newQuantity);

}
