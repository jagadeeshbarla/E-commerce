package com.shopapp.SpringbootappShop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;

import com.shopapp.SpringbootappShop.entities.ItemEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = ItemEntity.class)
public interface DaoItem {

	void save(ItemEntity itemEntity);
	List<ItemEntity> findAll();
	ItemEntity findById(Integer itemid);
	void deleteById(Integer itemid);
	@Modifying
	@Query("UPDATE ItemEntity i SET i.itemPrice = :newPrice, i.itemQuantity = :newQuantity WHERE i.itemid = :itemid")
	void updatePriceAndQuantityByItemid(Integer itemid, Double newPrice, Integer newQuantity);

}
