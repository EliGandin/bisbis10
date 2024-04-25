package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.services.DishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<DishDTO> getAllDishesByRestaurant(Long id) {
        List<DishDTO> dishDTOs = new ArrayList<>();
        Iterable<Dish> dishes = dishRepository.findAll();
        for (Dish dish : dishes) {
            DishDTO dto = new DishDTO();
            dto.setRestaurantId(dish.getRestaurant().getId());
            dto.setName(dish.getName());
            dto.setPrice(dish.getPrice());
            dishDTOs.add(dto);
        }
        return dishDTOs;
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

    @Override
    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public boolean updateDish(Long id, DishDTO dishDTO) {
        Dish target = getDishById(id);
        if (target == null) {
            return false;
        }
        target.setPrice(dishDTO.getPrice());
        target.setDescription(dishDTO.getDescription());
        dishRepository.save(target);
        return true;
    }

    @Override
    public boolean deleteDish(Long id) {
        Dish dish = getDishById(id);
        if (dish == null) {
            return false;
        }
        dishRepository.deleteById(id);
        return true;
    }
}
