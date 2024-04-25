package com.att.tdp.bisbis10.mappers.impl;

import com.att.tdp.bisbis10.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RestaurantMapperImpl implements Mapper<Restaurant, RestaurantDTO> {
    private final ModelMapper modelMapper;

    public RestaurantMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public RestaurantDTO mapTo(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    @Override
    public Restaurant mapFrom(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setCuisines(restaurantDTO.getCuisines());
        return restaurant;
    }
}
