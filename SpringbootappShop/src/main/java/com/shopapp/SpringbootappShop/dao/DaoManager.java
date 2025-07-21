package com.shopapp.SpringbootappShop.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;

import com.shopapp.SpringbootappShop.entities.CustomerEntity;
import com.shopapp.SpringbootappShop.entities.ManagerEntity;
import com.shopapp.SpringbootappShop.entities.ManagerPendingEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = ManagerEntity.class)
public interface DaoManager {
	public ManagerEntity save(ManagerEntity managerEntity);
	public List<ManagerEntity> findAll();
	public void deleteById(Integer managerBeanid);
}
