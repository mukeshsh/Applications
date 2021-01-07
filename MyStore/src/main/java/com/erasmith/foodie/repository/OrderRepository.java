package com.erasmith.foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erasmith.foodie.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
