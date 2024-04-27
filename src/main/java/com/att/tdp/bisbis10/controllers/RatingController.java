package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.RatingDTO;
import com.att.tdp.bisbis10.services.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController {
    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping(path = "/ratings")
    public ResponseEntity<Void> addRating(@RequestBody RatingDTO ratingDTO) {
        boolean isInserted = ratingService.addRating(ratingDTO);

        if (!isInserted) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
