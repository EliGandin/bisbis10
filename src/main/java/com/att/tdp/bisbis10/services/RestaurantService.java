package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Restaurant;

import java.util.Optional;

public interface RestaurantService {
    Iterable<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);
    Restaurant addRestaurant(Restaurant restaurant);
    Restaurant updateRestaurant(Long id,Restaurant newRestaurant);
    void deleteById(Long id);
    Iterable<Restaurant> getRestaurantsByCuisine(String cuisine);
}
