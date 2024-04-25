package com.att.tdp.bisbis10.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @Column(name = "rating")
    private Double rating;

    public Rating() {
    }

    public Rating(Long ratingId, Restaurant restaurant) {
        this.ratingId = ratingId;
        this.restaurant = restaurant;
    }

    public Long getRestaurantId() {
        return ratingId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.ratingId = restaurantId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

//    public List<Double> getRatingHistory() {
//        return ratingHistory;
//    }
//
//    public void setRatingHistory(List<Double> ratings) {
//        this.ratingHistory = ratings;
//    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double averageRating) {
        this.rating = averageRating;
    }

//    public void calculateAverageRating() {
//        if (!ratingHistory.isEmpty()) {
//            double sum = 0;
//            for (Double rating : ratingHistory) {
//                sum += rating;
//            }
//            averageRating = sum / ratingHistory.size();
//        } else {
//            averageRating = 0.0;
//        }
//    }
}