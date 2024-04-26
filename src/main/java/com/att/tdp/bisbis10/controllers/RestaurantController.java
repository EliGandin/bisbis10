package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.dtos.RestaurantWithDishes;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.mappers.impl.RestaurantMapperImpl;
import com.att.tdp.bisbis10.services.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
private final RestaurantService restaurantService;
private final RestaurantMapperImpl restaurantMapper;

    public RestaurantController(RestaurantService restaurantService, RestaurantMapperImpl restaurantMapper) {
        this.restaurantService = restaurantService;
        this.restaurantMapper = restaurantMapper;
    }

    @GetMapping(path = "/restaurants")
    public ResponseEntity<Iterable<Restaurant>> getAllRestaurants() {
        Iterable<Restaurant> result = restaurantService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/restaurants/{id}")
    public ResponseEntity<RestaurantWithDishes> getRestaurantById(@PathVariable("id") Long restaurantId) {
        RestaurantWithDishes result = restaurantService.getRestaurantWithDishes(restaurantId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path = "/restaurants")
    public ResponseEntity<Void> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurantEntity = restaurantMapper.mapFrom(restaurantDTO);
        restaurantService.addRestaurant(restaurantEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/restaurants/{id}")
    public ResponseEntity<Void> updateRestaurant(@PathVariable("id") Long id, @RequestBody RestaurantDTO restaurantDTO) {
        Restaurant restaurantEntity = restaurantMapper.mapFrom(restaurantDTO);
        restaurantService.updateRestaurant(id,restaurantEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/restaurants/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable("id") Long id) {
        restaurantService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/restaurants?cuisine={cuisine}")
    public ResponseEntity<Iterable<Restaurant>> getRestaurantsByCuisine(@PathVariable String cuisine) {
        Iterable<Restaurant> result = restaurantService.getRestaurantsByCuisine(cuisine);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
