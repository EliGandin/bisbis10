package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.dtos.RestaurantWithDishes;
import com.att.tdp.bisbis10.entities.Restaurant;

public interface RestaurantService {
    Iterable<Restaurant> findAll();
    Restaurant findById(Long id);
    boolean addRestaurant(RestaurantDTO restaurantDTO);
    boolean updateRestaurant(Long id,RestaurantDTO restaurantDTO);
    boolean deleteById(Long id);
    Iterable<Restaurant> getRestaurantsByCuisine(String cuisine);
    RestaurantWithDishes getRestaurantWithDishes(Long id);
}
