package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.dtos.OrderDTO;
import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.mappers.impl.OrderMapperImpl;
import com.att.tdp.bisbis10.repositories.OrderRepository;
import com.att.tdp.bisbis10.services.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapperImpl orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapperImpl orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public String addOrder(OrderDTO orderDTO) {
        Order order = orderMapper.mapFrom(orderDTO);
        orderRepository.save(order);
        return order.getOrderId();
    }
}
