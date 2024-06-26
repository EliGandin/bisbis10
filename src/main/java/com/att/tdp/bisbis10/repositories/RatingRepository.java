package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Rating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {

    @Query("SELECT r FROM Rating r WHERE r.restaurant.id = ?1")
    Iterable<Rating> findAllByRestaurantId(Long restaurantId);
}
