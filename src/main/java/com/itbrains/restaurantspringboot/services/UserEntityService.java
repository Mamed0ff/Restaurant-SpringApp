package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.user.ProfileDto;
import com.itbrains.restaurantspringboot.dtos.user.RegisterDto;
import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.models.UserEntity;

import java.util.List;

public interface UserEntityService {

    public UserDto findUserByEmail(String email);
    public boolean register(RegisterDto register);
    UserEntity findRealUserByEmail(String email);
    ProfileDto findProfileByEmail(String email);
    public List<UserDto> findAllUsers();
    boolean confirmEmail(String email, String token);

}
