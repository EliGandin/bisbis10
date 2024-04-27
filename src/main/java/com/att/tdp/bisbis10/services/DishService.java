package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;

public interface DishService {
    Iterable<Dish> getDishesByRestaurantId(Long id);
    boolean addDish(DishDTO dishDTO, Long restaurantId);
    boolean updateDish(Long id, DishDTO dishDTO);
    boolean deleteDish(Long id);
}
