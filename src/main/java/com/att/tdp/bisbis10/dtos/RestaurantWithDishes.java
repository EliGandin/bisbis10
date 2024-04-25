package com.att.tdp.bisbis10.dtos;

import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;

import java.util.List;

public class RestaurantWithDishes {
    private Restaurant restaurant;
    private Iterable<Dish> dishes;

    public RestaurantWithDishes() {
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Iterable<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Iterable<Dish> dishes) {
        this.dishes = dishes;
    }
}
