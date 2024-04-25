package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.mappers.Mapper;
import com.att.tdp.bisbis10.services.DishService;
import com.att.tdp.bisbis10.entities.Dish;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DishController {
    private final DishService dishService;

    private final Mapper<Dish, DishDTO> dishMapper;

    public DishController(DishService dishService, Mapper<Dish, DishDTO> dishMapper) {
        this.dishService = dishService;
        this.dishMapper = dishMapper;
    }

    @PostMapping(path = "/restaurants/{id}/dishes")
    public ResponseEntity<Dish> addDish(@RequestBody DishDTO dish, @PathVariable("id") Long restaurantId) {
        dish.setRestaurantId(restaurantId);
        Dish dishEntity = dishMapper.mapFrom(dish);
        dishService.addDish(dishEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/restaurants/{id}/dishes/{dishId}")
    public ResponseEntity<Void> updateDish(@RequestBody DishDTO dish, @PathVariable("id") Long id, @PathVariable("dishId") Long dishId) {
        boolean result = dishService.updateDish(dishId, dish);
        if (result) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/restaurants/{id}/dishes/{dishId}")
    public ResponseEntity<Void> deleteDishById(@PathVariable("id") Long id, @PathVariable("dishId") Long dishId) {
            dishService.deleteDish(dishId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/restaurants/{id}/dishes")
    public ResponseEntity<Dish> getDishByRestaurantId(@PathVariable("id") Long id) {
        Dish dish = dishService.getDishById(id);
        if (dish != null) {
            return new ResponseEntity<>(dish, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
