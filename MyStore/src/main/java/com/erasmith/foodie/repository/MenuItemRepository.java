package com.erasmith.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erasmith.foodie.entity.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

}
