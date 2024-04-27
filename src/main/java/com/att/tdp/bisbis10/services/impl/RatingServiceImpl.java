package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.dtos.RatingDTO;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.mappers.impl.RatingMapperImpl;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import com.att.tdp.bisbis10.services.RatingService;
import org.springframework.stereotype.Service;


@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final RestaurantRepository restaurantRepository;
    private final RatingMapperImpl ratingMapper;

    public RatingServiceImpl(RatingRepository ratingRepository, RestaurantRepository restaurantRepository, RatingMapperImpl ratingMapper) {
        this.ratingRepository = ratingRepository;
        this.restaurantRepository = restaurantRepository;
        this.ratingMapper = ratingMapper;
    }

    @Override
    public boolean addRating(RatingDTO newRatingDTO) {
        Rating rating = ratingMapper.mapFrom(newRatingDTO);
        Restaurant restaurant = rating.getRestaurant();
        Iterable<Rating> ratings = ratingRepository.findAllByRestaurantId(restaurant.getId());

        double newAvgRating = calculateAvgRating(ratings, newRatingDTO.getRating());
        restaurant.setAvgRating(newAvgRating);
        restaurantRepository.save(restaurant);
        ratingRepository.save(rating);

        return restaurant.getId() != null;
    }

    private double calculateAvgRating(Iterable<Rating> ratings, double newRating) {
        double total = 0;
        int size = 0;
        for (Rating rating : ratings) {
            total += rating.getRating();
            size++;
        }
        if (size > 0) {
            return (total + newRating) / (size + 1);
        } else {
            return newRating;
        }
    }
}
