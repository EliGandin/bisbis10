package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.repositories.OrderRepository;
import com.att.tdp.bisbis10.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public boolean addOrder(Order order) {
        orderRepository.save(order);
        return true;
    }
}
