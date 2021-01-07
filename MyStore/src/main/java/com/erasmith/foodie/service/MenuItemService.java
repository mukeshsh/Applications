package com.erasmith.foodie.service;

import java.util.List;
import java.util.Optional;

import com.erasmith.foodie.entity.MenuItem;

public interface MenuItemService {
	
	MenuItem save(MenuItem menuItem);
    List<MenuItem> findAll();
    Optional<MenuItem> findById(Long id);

}
