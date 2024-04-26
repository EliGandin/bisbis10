package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.OrderDTO;
import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.mappers.impl.OrderMapperImpl;
import com.att.tdp.bisbis10.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderMapperImpl orderMapper;
    private final OrderService orderService;

    public OrderController(OrderMapperImpl orderMapper, OrderService orderService) {
        this.orderMapper = orderMapper;
        this.orderService = orderService;
    }

    @PostMapping(path = "/order")
    public ResponseEntity<String> addOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderMapper.mapFrom(orderDTO);
        orderService.addOrder(order);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
