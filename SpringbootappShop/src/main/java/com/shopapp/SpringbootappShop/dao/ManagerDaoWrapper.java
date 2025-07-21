package com.shopapp.SpringbootappShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopapp.SpringbootappShop.beans.ItemBean;
import com.shopapp.SpringbootappShop.entities.ItemEntity;

@Repository
public class ManagerDaoWrapper {
	@Autowired
	DaoItem daoItem;

	public void addNewProduct(ItemBean itemBean) {
		ItemEntity itemEntity = new ItemEntity();
		BeanUtils.copyProperties(itemBean,itemEntity);
		daoItem.save(itemEntity);
	}
	public List<ItemBean> getAllItems(){
		List<ItemEntity> ItemEntityList= daoItem.findAll();
		List<ItemBean> itemBeanList = new ArrayList<ItemBean>();
		
		for( ItemEntity itemEntity : ItemEntityList) {
			ItemBean itemBean = new ItemBean();
			BeanUtils.copyProperties(itemEntity, itemBean);
			itemBeanList.add(itemBean);			
		}
		return itemBeanList;
	}

	public ItemBean getItemByInteger(Integer itemid) {
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(daoItem.findById(itemid), itemBean);
		return itemBean;
	}
	public void removeProduct(Integer itemid) {
		daoItem.deleteById(itemid);
	}
	public void updateItemDetails(Integer itemBeanid, Double newPrice, Integer newQuantity) {
		daoItem.updatePriceAndQuantityByItemid(itemBeanid,newPrice,newQuantity);
	}

}
