package com.itbrains.restaurantspringboot.dtos.about;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AboutDto {
    private Long id;
    private String iconUrl;
    private String title;
    private String description;
}
