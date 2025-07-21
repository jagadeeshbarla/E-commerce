package com.shopapp.SpringbootappShop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shopapp.SpringbootappShop.beans.ItemBean;
import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.entities.ItemEntity;
import com.shopapp.SpringbootappShop.entities.ManagerPendingEntity;

@Repository
public class CustomerDaoWrapper {
	@Autowired
	DaoItem daoItem;
	
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

}
