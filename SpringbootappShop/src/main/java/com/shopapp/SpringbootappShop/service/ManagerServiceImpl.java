package com.shopapp.SpringbootappShop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shopapp.SpringbootappShop.beans.CustomerBean;
import com.shopapp.SpringbootappShop.beans.ItemBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.dao.ManagerDaoWrapper;

import jakarta.transaction.Transactional;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	ManagerDaoWrapper managerDaoWrapper;
	
	@Override
	public void addproduct(ItemBean itemBean , MultipartFile image) {
		itemBean.setImageName(image.getOriginalFilename());
		itemBean.setImageType(image.getContentType());
		try {
			itemBean.setImageDate(image.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		managerDaoWrapper.addNewProduct(itemBean);
	}
	@Override
	public List<ItemBean> getAllItems() {
		return managerDaoWrapper.getAllItems();
	}
	@Override
	public ItemBean getItemById(Integer itemid) {
		return managerDaoWrapper.getItemByInteger(itemid);
	}
	@Override
	public void removeProduct(Integer itemid) {
		managerDaoWrapper.removeProduct(itemid);
	}
	@Override
	@Transactional
	public void updateItemDetails(Integer itemBeanid, Double newPrice, Integer newQuantity) {
		managerDaoWrapper.updateItemDetails(itemBeanid,newPrice,newQuantity);
		
	}

	

}
