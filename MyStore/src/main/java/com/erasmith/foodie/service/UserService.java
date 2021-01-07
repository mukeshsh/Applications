package com.erasmith.foodie.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.erasmith.foodie.entity.User;

public interface UserService extends UserDetailsService {
	  Optional<User> findById(Long id);
}
