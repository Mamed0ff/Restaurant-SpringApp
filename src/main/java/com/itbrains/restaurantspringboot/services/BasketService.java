package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.basket.BasketDto;

import java.util.List;

public interface BasketService {
    public void add(Long foodId, String userEmail);
    public BasketDto getBasketByUserEmail(String userEmail);
    public void remove(Long foodId, String userEmail);
}
