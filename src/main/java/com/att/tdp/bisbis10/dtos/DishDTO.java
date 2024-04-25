package com.att.tdp.bisbis10.dtos;

public class DishDTO {
    private Long id;
    private Long restaurantId;
    private String name;
    private double price;
    private String description;


    public DishDTO() {
    }

    public DishDTO(Long restaurantId, String name, double price, String description) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
