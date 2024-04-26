package com.att.tdp.bisbis10.mappers.impl;

import com.att.tdp.bisbis10.dtos.OrderItemDTO;
import com.att.tdp.bisbis10.entities.OrderItem;
import com.att.tdp.bisbis10.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapperImpl implements Mapper<OrderItem, OrderItemDTO> {
    private final ModelMapper modelMapper;

    public OrderItemMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public OrderItemDTO mapTo(OrderItem orderItem) {
        return modelMapper.map(orderItem, OrderItemDTO.class);
    }

    @Override
    public OrderItem mapFrom(OrderItemDTO orderItemDTO) {
        OrderItem orderItem = new OrderItem();
        orderItem.setDishId(orderItemDTO.getDishId());
        orderItem.setAmount(orderItemDTO.getAmount());
        return orderItem;
    }
}
