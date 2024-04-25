package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.dtos.RestaurantWithDishes;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import com.att.tdp.bisbis10.services.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final DishServiceImpl dishService;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, DishServiceImpl dishService) {
        this.restaurantRepository = restaurantRepository;
        this.dishService = dishService;
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long id, Restaurant newRestaurant) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        restaurant.get().setCuisines(newRestaurant.getCuisines());
        restaurantRepository.save(restaurant.get());
        return restaurant.get();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        restaurantRepository.delete(restaurant.get());
    }

    @Override
    public Iterable<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findAllByCuisine(cuisine);
    }

    public RestaurantWithDishes getRestaurantWithDishes(Long id) {
        RestaurantWithDishes res = new RestaurantWithDishes();
        Optional<Restaurant> restaurant = findById(id);
        Iterable<Dish> dishes = dishService.getDishesById(id);

        res.setRestaurant(restaurant.get());
        res.setDishes(dishes);

        return res;
    }
}
