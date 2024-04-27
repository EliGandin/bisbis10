package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.dtos.RestaurantWithDishes;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.mappers.impl.RestaurantMapperImpl;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import com.att.tdp.bisbis10.services.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final DishServiceImpl dishService;
    private final RestaurantMapperImpl restaurantMapper;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, DishServiceImpl dishService, RestaurantMapperImpl restaurantMapper) {
        this.restaurantRepository = restaurantRepository;
        this.dishService = dishService;
        this.restaurantMapper = restaurantMapper;
    }

    @Override
    public Restaurant findById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if (restaurant.isEmpty()) {
            return null;
        }

        return restaurant.get();
    }

    @Override
    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public boolean addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurantEntity = restaurantMapper.mapFrom(restaurantDTO);
        Restaurant restaurant = restaurantRepository.save(restaurantEntity);

        return restaurant.getId() != null;
    }

    @Override
    public boolean updateRestaurant(Long id, RestaurantDTO restaurantDTO) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if (restaurant.isEmpty()) {
            return false;
        }

        restaurant.get().setCuisines(restaurantDTO.getCuisines());
        restaurantRepository.save(restaurant.get());
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        if (restaurant.isEmpty()) {
            return false;
        }

        restaurantRepository.delete(restaurant.get());
        return true;
    }

    @Override
    public Iterable<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantRepository.findAllByCuisine(cuisine);
    }

    public RestaurantWithDishes getRestaurantWithDishes(Long id) {
        RestaurantWithDishes res = new RestaurantWithDishes();
        Restaurant restaurant = findById(id);
        Iterable<Dish> dishes = dishService.getDishesByRestaurantId(id);

        res.setRestaurant(restaurant);
        res.setDishes(dishes);

        return res;
    }
}
