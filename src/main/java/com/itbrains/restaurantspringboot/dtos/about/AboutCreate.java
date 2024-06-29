package com.itbrains.restaurantspringboot.dtos.about;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AboutCreate {
    private String title;
    private String description;
}
