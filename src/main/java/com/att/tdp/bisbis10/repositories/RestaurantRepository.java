package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Restaurant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r WHERE :cuisine MEMBER OF r.cuisines")
    Iterable<Restaurant> findAllByCuisine(String cuisine);
}
