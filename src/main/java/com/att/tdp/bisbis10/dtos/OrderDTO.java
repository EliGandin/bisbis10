package com.att.tdp.bisbis10.dtos;

import com.att.tdp.bisbis10.entities.Dish;

import java.util.List;
import java.util.Map;

public class OrderDTO {
    private Long restaurantId;
    private List<OrderItemDTO> orderItems;

    public OrderDTO(Long restaurantId, List<OrderItemDTO> orderItems) {
        this.restaurantId = restaurantId;
        this.orderItems = orderItems;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
}
