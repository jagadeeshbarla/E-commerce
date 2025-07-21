package com.shopapp.SpringbootappShop.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import com.shopapp.SpringbootappShop.entities.UserEntity;

@RepositoryDefinition(idClass = Integer.class , domainClass = UserEntity.class)
public interface DaoUser {
	public UserEntity save(UserEntity userEntity);
	
	@Query("SELECT u FROM UserEntity u WHERE u.userName = :username")
	public Optional<UserEntity> findByUserName(@Param("username") String username);
	
	@Query("SELECT COUNT(u) > 0 FROM UserEntity u WHERE u.userName = :username")
	boolean existsByUsername(@Param("username") String username);
}
