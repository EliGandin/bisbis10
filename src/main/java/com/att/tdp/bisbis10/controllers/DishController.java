package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.services.DishService;
import com.att.tdp.bisbis10.entities.Dish;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DishController {
    private final DishService dishService;

    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping(path = "/restaurants/{id}/dishes")
    public ResponseEntity<Dish> addDish(@RequestBody DishDTO dishDTO, @PathVariable("id") Long restaurantId) {
        boolean isInserted = dishService.addDish(dishDTO, restaurantId);

        if (!isInserted) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(path = "/restaurants/{id}/dishes/{dishId}")
    public ResponseEntity<Void> updateDish(@RequestBody DishDTO dish, @PathVariable("id") Long id, @PathVariable("dishId") Long dishId) {
        boolean isUpdated = dishService.updateDish(dishId, dish);

        if (!isUpdated) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(path = "/restaurants/{id}/dishes/{dishId}")
    public ResponseEntity<Void> deleteDishById(@PathVariable("id") Long id, @PathVariable("dishId") Long dishId) {
        boolean isDeleted = dishService.deleteDish(dishId);

        if (!isDeleted) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/restaurants/{id}/dishes")
    public ResponseEntity<Iterable<Dish>> getDishesByRestaurantId(@PathVariable("id") Long restaurantId) {
        Iterable<Dish> result = dishService.getDishesByRestaurantId(restaurantId);

        if (!result.iterator().hasNext()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
