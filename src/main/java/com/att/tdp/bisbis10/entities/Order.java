package com.att.tdp.bisbis10.entities;

import com.att.tdp.bisbis10.converters.MapToJsonConverter;
import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @Convert(converter = MapToJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<Dish, Integer> orderItems;

    public Order() {
    }

    public Order(Restaurant restaurant, Map<Dish, Integer> orderItems) {
        this.restaurant = restaurant;
        this.orderItems = orderItems; //TODO:
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Map<Dish, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<Dish, Integer> orderItems) {
        this.orderItems = orderItems;
    }
}
