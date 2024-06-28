package com.itbrains.restaurantspringboot.helpers;

import com.itbrains.restaurantspringboot.models.Food;

import java.util.List;

public class Calculator {
    public static double calculator(List<Food> foods){
        double sum = 0;
        for(Food item : foods){
            sum += item.getPrice()*item.getQuantity();
        }
        return sum;
    }
}
