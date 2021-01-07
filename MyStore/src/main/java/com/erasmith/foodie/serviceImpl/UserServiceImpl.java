package com.erasmith.foodie.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.erasmith.foodie.entity.User;
import com.erasmith.foodie.repository.UserRepository;
import com.erasmith.foodie.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	    UserRepository userRepository;

	    @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        Optional<User> user = userRepository.findByEmail(email);

	        if (user.isPresent()) {
	            return user.get();
	        }

	        throw new UsernameNotFoundException("Invalid Username");
	    }

	    @Override
	    public Optional<User> findById(Long id) {
	        return userRepository.findById(id);
	    }
	}
