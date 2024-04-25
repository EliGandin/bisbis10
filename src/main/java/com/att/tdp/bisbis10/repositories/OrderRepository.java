package com.att.tdp.bisbis10.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.att.tdp.bisbis10.entities.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
}
