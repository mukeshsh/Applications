package com.erasmith.foodie.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erasmith.foodie.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);

}
