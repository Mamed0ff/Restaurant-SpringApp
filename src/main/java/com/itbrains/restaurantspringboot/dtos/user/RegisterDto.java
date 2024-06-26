package com.itbrains.restaurantspringboot.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterDto {
    private String email;
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
}
