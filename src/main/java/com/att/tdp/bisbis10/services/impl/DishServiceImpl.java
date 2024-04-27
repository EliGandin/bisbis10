package com.att.tdp.bisbis10.services.impl;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.mappers.impl.DishMapperImpl;
import com.att.tdp.bisbis10.repositories.DishRepository;
import com.att.tdp.bisbis10.services.DishService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository dishRepository;
    private final DishMapperImpl dishMapper;

    public DishServiceImpl(DishRepository dishRepository, DishMapperImpl dishMapper) {
        this.dishRepository = dishRepository;
        this.dishMapper = dishMapper;
    }

    @Override
    public Iterable<Dish> getDishesByRestaurantId(Long id) {
        return dishRepository.findAllByRestaurantId(id);
    }

    @Override
    public boolean addDish(DishDTO dishDTO, Long restaurantId) {
        dishDTO.setRestaurantId(restaurantId);
        Dish dish = dishMapper.mapFrom(dishDTO);
        dishRepository.save(dish);

        return dish.getId() != null;
    }

    @Override
    public boolean updateDish(Long id, DishDTO dishDTO) {
        Optional<Dish> target = dishRepository.findById(id);

        if (target.isEmpty()) {
            return false;
        }

        Dish dish = target.get();
        dish.setPrice(dishDTO.getPrice());
        dish.setDescription(dishDTO.getDescription());
        dishRepository.save(dish);
        return true;
    }

    @Override
    public boolean deleteDish(Long id) {
        Optional<Dish> dish = dishRepository.findById(id);

        if (dish.isEmpty()) {
            return false;
        }

        dishRepository.deleteById(id);
        return true;
    }
}
