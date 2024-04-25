package com.att.tdp.bisbis10.dtos;

public class RatingDTO {
    Long restaurantId;
    Double rating;

    public RatingDTO(Long restaurantId, Double rating) {
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}
