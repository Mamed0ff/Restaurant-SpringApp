package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.role.RoleDto;
import com.itbrains.restaurantspringboot.dtos.user.ProfileDto;
import com.itbrains.restaurantspringboot.dtos.user.RegisterDto;
import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.models.Role;
import com.itbrains.restaurantspringboot.models.UserEntity;
import com.itbrains.restaurantspringboot.repos.RoleRepository;
import com.itbrains.restaurantspringboot.repos.UserEntityRepository;
import com.itbrains.restaurantspringboot.services.RoleService;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserEntityService {
    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleService roleService;


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
        userEntityRepository.saveAndFlush(newUser);
        Role role = roleService.getRealRoleById(2L);
        List<Role> roles = newUser.getRoles();
        roles.add(role);
        newUser.setRoles(roles);
        userEntityRepository.saveAndFlush(newUser);
        rabbitTemplate.convertAndSend(fanoutExchange.getName(),"",register.getEmail());
        return true;
    }


    public UserEntity findRealUserByEmail(String email) {
        UserEntity user = userEntityRepository.findByEmail(email);
        return user;
    }

    @Override
    public ProfileDto findProfileByEmail(String email) {
        UserEntity user = userEntityRepository.findByEmail(email);
        return modelMapper.map(user,ProfileDto.class);
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<UserEntity> users= userEntityRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public boolean confirmEmail(String email, String token) {
        UserEntity findUser = userEntityRepository.findByEmail(email);
        if (findUser.getConfirmationToken().equals(token) && findUser != null)
        {
        findUser.setEmailConfirmed(true);
            userEntityRepository.saveAndFlush(findUser);
        return true;
        }
        return false;
    }
}
