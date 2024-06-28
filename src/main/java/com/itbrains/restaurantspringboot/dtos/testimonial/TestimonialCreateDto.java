package com.itbrains.restaurantspringboot.dtos.testimonial;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class TestimonialCreateDto {

    private String description;
    private Long foodId;
}
