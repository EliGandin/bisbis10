package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;

import java.util.List;

public interface DishService {
    List<DishDTO> getAllDishesByRestaurant(Long id);
    Dish getDishById(Long id);
    void addDish(Dish dish);
    boolean updateDish(Long id, DishDTO dishDTO);
    boolean deleteDish(Long id);
}
