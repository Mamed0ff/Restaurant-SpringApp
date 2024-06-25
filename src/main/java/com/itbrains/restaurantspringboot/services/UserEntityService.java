package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.user.UserDto;

public interface UserEntityService {

    public UserDto findUserByEmail(String email);
}
