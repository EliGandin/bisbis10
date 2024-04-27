package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.dtos.RestaurantWithDishes;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(path = "/restaurants")
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurants() {
        Iterable<Restaurant> result = restaurantService.findAll();

        if (!result.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/restaurants/{id}")
    public ResponseEntity<RestaurantWithDishes> getRestaurantById(@PathVariable("id") Long restaurantId) {
        RestaurantWithDishes result = restaurantService.getRestaurantWithDishes(restaurantId);

        if (result.getRestaurant() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/restaurants")
    public ResponseEntity<Void> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        boolean isInserted = restaurantService.addRestaurant(restaurantDTO);
        if (!isInserted) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/restaurants/{id}")
    public ResponseEntity<Void> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDTO restaurantDTO) {
        boolean isUpdated = restaurantService.updateRestaurant(id, restaurantDTO);
        if (!isUpdated) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/restaurants/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id) {
        boolean isDeleted = restaurantService.deleteById(id);

        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/restaurants?cuisine={cuisine}")
    public ResponseEntity<Iterable<Restaurant>> getRestaurantsByCuisine(@PathVariable String cuisine) {
        Iterable<Restaurant> result = restaurantService.getRestaurantsByCuisine(cuisine);

        if (!result.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
