package com.itbrains.restaurantspringboot.dtos.user;

import com.itbrains.restaurantspringboot.models.Order;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String photoUrl;
}
