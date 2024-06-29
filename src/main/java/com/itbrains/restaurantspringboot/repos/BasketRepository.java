package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Basket;
import com.itbrains.restaurantspringboot.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface BasketRepository extends JpaRepository<Basket, Long> {
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM basket_foods WHERE basket_id = :basketId AND food_id = :foodId", nativeQuery = true)
    void removeFoodFromBasket(Long basketId, Long foodId);

}
