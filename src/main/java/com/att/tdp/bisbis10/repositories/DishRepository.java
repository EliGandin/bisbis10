package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Dish;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
    @Query("SELECT d.id,d.name, d.description,d.price FROM Dish d WHERE d.restaurant.id = ?1")
    Iterable<Dish> findAllByRestaurantId(Long restaurantId);
}
