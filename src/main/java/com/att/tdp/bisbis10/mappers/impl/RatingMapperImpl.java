package com.att.tdp.bisbis10.mappers.impl;

import com.att.tdp.bisbis10.dtos.RatingDTO;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.mappers.Mapper;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RatingMapperImpl implements Mapper<Rating, RatingDTO> {
    private final ModelMapper modelMapper;
    private final RestaurantRepository restaurantRepository;

    public RatingMapperImpl(ModelMapper modelMapper, RestaurantRepository restaurantRepository) {
        this.modelMapper = modelMapper;
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public RatingDTO mapTo(Rating rating) {
        return modelMapper.map(rating, RatingDTO.class);
    }

    @Override
    public Rating mapFrom(RatingDTO ratingDTO) {
        Rating rating = new Rating();
        Restaurant restaurant = restaurantRepository.findById(ratingDTO.getRestaurantId())
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        rating.setRestaurant(restaurant);
        rating.setRating(ratingDTO.getRating());

        restaurantRepository.save(restaurant);
        return rating;
    }
}
