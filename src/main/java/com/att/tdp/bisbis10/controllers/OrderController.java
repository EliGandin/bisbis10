package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.OrderDTO;
import com.att.tdp.bisbis10.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(path = "/order")
    public ResponseEntity<String> addOrder(@RequestBody OrderDTO orderDTO) {
        String orderId = orderService.addOrder(orderDTO);

        if (orderId.isBlank()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(orderId, HttpStatus.OK);
    }
}
