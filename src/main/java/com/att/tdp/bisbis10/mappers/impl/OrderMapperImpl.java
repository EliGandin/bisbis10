package com.att.tdp.bisbis10.mappers.impl;

import com.att.tdp.bisbis10.dtos.OrderDTO;
import com.att.tdp.bisbis10.dtos.OrderItemDTO;
import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.entities.OrderItem;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.mappers.Mapper;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import com.att.tdp.bisbis10.services.OrderItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OrderMapperImpl implements Mapper<Order, OrderDTO> {
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;
    private final OrderItemMapperImpl orderItemMapper;
    private final OrderItemService orderItemService;

    public OrderMapperImpl(ModelMapper modelMapper, RestaurantRepository restaurantRepository, OrderItemMapperImpl orderItemMapper, OrderItemService orderItemService) {
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
        this.orderItemMapper = orderItemMapper;
        this.orderItemService = orderItemService;
    }

    @Override
    public OrderDTO mapTo(Order order) {
        return modelMapper.map(order, OrderDTO.class);
    }

    @Override
    public Order mapFrom(OrderDTO orderDTO) {
        Order order = new Order();
        Restaurant restaurant = restaurantRepository.findById(orderDTO.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        String orderId = UUID.randomUUID().toString();

        for (OrderItemDTO orderItemDTO : orderDTO.getOrderItems()) {
            OrderItem temp = orderItemMapper.mapFrom(orderItemDTO);
            temp.setOrderId(orderId);
            boolean result = orderItemService.addOrderItem(temp);
            if (!result) {
                throw new RuntimeException("Order Item Failed");
            }
        }

        order.setRestaurant(restaurant);
        order.setOrderId(orderId);
        return order;
    }
}
