package com.itbrains.restaurantspringboot.dtos.category;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryUpdateDto {
    private long id;
    private String name;
}
