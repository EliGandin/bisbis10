package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.RatingDTO;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.mappers.impl.RatingMapperImpl;
import com.att.tdp.bisbis10.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
    private final RatingService ratingService;
    private final RatingMapperImpl ratingMapper;

    public RatingController(RatingService ratingService, RatingMapperImpl ratingMapper) {
        this.ratingService = ratingService;
        this.ratingMapper = ratingMapper;
    }

    @PostMapping(path ="/ratings")
    public ResponseEntity<Void> addRating(@RequestBody RatingDTO ratingDTO) {
        Rating ratingEntity = ratingMapper.mapFrom(ratingDTO);
        ratingService.addRating(ratingEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
