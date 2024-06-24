package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository    extends CrudRepository<Order, Long> {
}
