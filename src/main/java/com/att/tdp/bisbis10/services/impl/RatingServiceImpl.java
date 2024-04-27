package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RatingRepository;
import com.att.tdp.bisbis10.repositories.RestaurantRepository;
import com.att.tdp.bisbis10.services.RatingService;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantServiceImpl restaurantService;

    public RatingServiceImpl(RatingRepository ratingRepository,RestaurantRepository restaurantRepository, RestaurantServiceImpl restaurantService) {
        this.ratingRepository = ratingRepository;
        this.restaurantRepository = restaurantRepository;
        this.restaurantService = restaurantService;
    }

    @Override
    public void addRating(Rating newRating) {
        Restaurant restaurant = newRating.getRestaurant();
        Iterable<Rating> ratings= ratingRepository.findAllByRestaurantId(restaurant.getId());

        double newAvgRating = calculateAvgRating(ratings, newRating.getRating());
        restaurant.setAvgRating(newAvgRating);
//        restaurantService.addRestaurant(restaurant);
        ratingRepository.save(newRating);
    }

    private double calculateAvgRating(Iterable<Rating> ratings, double newRating) {
        double total = 0;
        int size = 0;
        for (Rating rating : ratings) {
            total += rating.getRating();
            size++;
        }
        if (size > 0) {
            return (total + newRating) / (size+1);
        } else {
            return newRating;
        }
    }
}
