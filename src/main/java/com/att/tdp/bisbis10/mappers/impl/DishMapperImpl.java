package com.att.tdp.bisbis10.mappers.impl;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.mappers.Mapper;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DishMapperImpl implements Mapper<Dish, DishDTO> {
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;

    public DishMapperImpl(ModelMapper modelMapper, RestaurantRepository restaurantRepository) {
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public DishDTO mapTo(Dish dish) {
        return modelMapper.map(dish, DishDTO.class);
    }

    @Override
    public Dish mapFrom(DishDTO dishDTO) {
        Dish dish = new Dish();
        dish.setName(dishDTO.getName());
        dish.setPrice(dishDTO.getPrice());
        dish.setDescription(dishDTO.getDescription());


        Restaurant restaurant = restaurantRepository.findById(dishDTO.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        dish.setRestaurant(restaurant);

        return dish;
    }
}