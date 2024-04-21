package com.att.tdp.bisbis10.domain;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "restaurants_id_seq")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="restaurant_id")
    private Restaurant restaurant;

    @ElementCollection
    private Map<Dish, Integer> orderItems;
}
