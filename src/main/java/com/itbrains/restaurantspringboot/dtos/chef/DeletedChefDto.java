package com.itbrains.restaurantspringboot.dtos.chef;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeletedChefDto {
    private long id;
    private String surname;
    private String name;
    public String photoUrl;
    private String speciality;
}
