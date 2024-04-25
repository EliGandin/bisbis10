package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.services.DishService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public Iterable<Dish> getDishesById(Long id) {
        return dishRepository.findAllByRestaurantId(id);
    }

    @Override
    public void addDish(Dish dish) {
        dishRepository.save(dish);
    }

    @Override
    public boolean updateDish(Long id, DishDTO dishDTO) {
        Optional<Dish> target = dishRepository.findById(id);

        target.get().setPrice(dishDTO.getPrice());
        target.get().setDescription(dishDTO.getDescription());
        dishRepository.save(target.get());
        return true;
    }

    @Override
    public boolean deleteDish(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);
        dishRepository.deleteById(id);
        return true;
    }
}
