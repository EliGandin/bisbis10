package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<Dish, Long> {
}
