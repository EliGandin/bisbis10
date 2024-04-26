package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
