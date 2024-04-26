package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.entities.OrderItem;
import com.att.tdp.bisbis10.repositories.OrderItemRepository;
import com.att.tdp.bisbis10.services.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
}
