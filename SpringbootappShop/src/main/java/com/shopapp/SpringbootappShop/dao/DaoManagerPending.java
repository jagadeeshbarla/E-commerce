package com.shopapp.SpringbootappShop.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import com.shopapp.SpringbootappShop.beans.ManagerPendingBean;
import com.shopapp.SpringbootappShop.entities.CustomerEntity;
import com.shopapp.SpringbootappShop.entities.ManagerPendingEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = ManagerPendingEntity.class)
public interface DaoManagerPending {
	
	public ManagerPendingEntity save(ManagerPendingEntity managerPendingEntity);
	public List<ManagerPendingEntity> findAll();
	public void deleteById(Integer managerPendingBeanid);
	ManagerPendingEntity findByManagerPendingid(Integer managerPendingid);
}
