package com.itbrains.restaurantspringboot.dtos.chef;

import lombok.Data;

import java.util.Date;

@Data
public class ChefDto {
    private long id;
    private String surname;
    private String name;
    private Date joinedDate;
    public String photoUrl;
    private String speciality;
}
