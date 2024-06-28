package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Basket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketRepository extends JpaRepository<Basket, Long> {

}
