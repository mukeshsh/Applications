package com.erasmith.foodie.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.erasmith.foodie.entity.Order;
import com.erasmith.foodie.repository.OrderRepository;
import com.erasmith.foodie.service.OrderService;

public class OrderServiceImpl implements OrderService {

	 @Autowired
	    private OrderRepository orderRepository;

	    @Override
	    public Order save(Order order) {
	        return orderRepository.save(order);
	    }
	}
