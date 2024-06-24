package com.itbrains.restaurantspringboot.dtos.chef;

import lombok.Data;

@Data
public class ChefShowDto {
    private long id;
    private String surname;
    private String name;
    public String photoUrl;
    private String speciality;
}
