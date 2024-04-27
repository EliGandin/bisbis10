package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dtos.RatingDTO;


public interface RatingService {
    boolean addRating(RatingDTO newRatingDTO);
}
