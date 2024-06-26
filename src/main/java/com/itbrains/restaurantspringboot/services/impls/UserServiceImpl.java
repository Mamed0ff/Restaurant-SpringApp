package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.user.RegisterDto;
import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.models.UserEntity;
import com.itbrains.restaurantspringboot.repos.UserEntityRepository;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserEntityService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDto findUserByEmail(String email) {
        UserEntity user = userEntityRepository.findByEmail(email);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public boolean register(RegisterDto register) {
        UserEntity user = userEntityRepository.findByEmail(register.getEmail());
        if (user != null) {
            return false;
        }
        else if (!register.getPassword().equals(register.getConfirmPassword())) {
            return false;
        }
        String token = passwordEncoder.encode(register.getEmail());
        String hashedPassword = passwordEncoder.encode(register.getPassword());
        UserEntity newUser= modelMapper.map(register, UserEntity.class);
        newUser.setPassword(hashedPassword);
        newUser.setConfirmationToken(token);
        userEntityRepository.save(newUser);
        return true;
    }
}
