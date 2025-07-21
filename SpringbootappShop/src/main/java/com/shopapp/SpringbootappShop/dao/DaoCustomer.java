package com.shopapp.SpringbootappShop.dao;

import java.util.List;

import org.springframework.data.repository.RepositoryDefinition;


import com.shopapp.SpringbootappShop.entities.CustomerEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = CustomerEntity.class)
public interface DaoCustomer {
	public CustomerEntity save(CustomerEntity customerEntity);

	public List<CustomerEntity> findAll();

	public void deleteById(Integer customerBeanid);

}
