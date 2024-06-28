package com.itbrains.restaurantspringboot.dtos.testimonial;

import com.itbrains.restaurantspringboot.dtos.food.FoodMenuDto;
import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TestimonialShowDto {
    private Long id;
    private String description;
    private Date postedDate;
    private UserDto user;
    private FoodMenuDto food;
}
