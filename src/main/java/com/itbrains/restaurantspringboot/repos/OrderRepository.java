package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository    extends JpaRepository<Order, Long> {
}
