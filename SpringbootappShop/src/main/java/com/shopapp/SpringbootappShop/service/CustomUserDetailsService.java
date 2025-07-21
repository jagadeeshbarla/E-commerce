package com.shopapp.SpringbootappShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shopapp.SpringbootappShop.dao.DaoUser;
import com.shopapp.SpringbootappShop.entities.UserEntity;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private DaoUser daoUser;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println(username);
        UserEntity user = daoUser.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.withUsername(user.getUserName())
                .password(user.getUserPassword()) // plain text password
                .roles(user.getUserRole())        // e.g. "ADMIN", "CUSTOMER"
                .build();
    }
}

