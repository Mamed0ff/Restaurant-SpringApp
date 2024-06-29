package com.itbrains.restaurantspringboot.dtos.about;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class AboutUpdateDto {

        private Long id;
        private String title;
        private String description;
}
