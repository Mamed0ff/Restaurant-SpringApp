package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.models.User;
import com.itbrains.restaurantspringboot.repos.UserEntityRepository;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDto findUserByEmail(String email) {
        User user = userEntityRepository.findByEmail(email);
        return modelMapper.map(user, UserDto.class);
    }
}
