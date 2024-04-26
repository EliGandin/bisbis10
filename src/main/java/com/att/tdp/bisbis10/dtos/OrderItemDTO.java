package com.att.tdp.bisbis10.dtos;

public class OrderItemDTO {
    private Long dishId;
    private Integer amount;

    public OrderItemDTO(Long dishId, Integer amount) {
        this.dishId = dishId;
        this.amount = amount;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
