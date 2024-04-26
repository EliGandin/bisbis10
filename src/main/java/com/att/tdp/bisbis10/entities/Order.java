package com.att.tdp.bisbis10.entities;

import com.att.tdp.bisbis10.converters.MapToJsonConverter;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
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

//    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<OrderItem> orderItems;

    @Column
    private String orderId;

    public Order() {
    }

    public Order(Restaurant restaurant, List<OrderItem> orderItems) {
        this.restaurant = restaurant;
//        this.orderItems = orderItems;
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

//    public List<OrderItem> getOrderItems() {
//        return orderItems;
//    }
//
//    public void setOrderItems(List<OrderItem> orderItems) {
//        this.orderItems = orderItems;
//    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
