package com.itbrains.restaurantspringboot.dtos.chef;

import lombok.Data;

@Data
public class ChefCreateDto {
    private String surname;
    private String name;
    public String photoUrl;
    private String speciality;
}
