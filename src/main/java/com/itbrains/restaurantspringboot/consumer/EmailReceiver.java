package com.itbrains.restaurantspringboot.consumer;

import com.itbrains.restaurantspringboot.dtos.role.RoleDto;
import com.itbrains.restaurantspringboot.models.Role;
import com.itbrains.restaurantspringboot.models.UserEntity;
import com.itbrains.restaurantspringboot.repos.UserEntityRepository;
import com.itbrains.restaurantspringboot.services.EmailService;
import com.itbrains.restaurantspringboot.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailReceiver {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserEntityRepository userRepo;

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "email-sender-queue")
    public void recieveEmail(String email) {
        emailService.sendConfirmationEmail(email);
    }

//    @RabbitListener(queues = "user-role-giver-queue")
//    public void recieveUserEmail(String email) {
//        UserEntity user = userRepo.findByEmail(email);
//        RoleDto roleDto = roleService.getRoleById(2);
//        Role role =modelMapper.map(roleDto, Role.class);
//        user.getRoles().add(role);
//        userRepo.save(user);


//        RoleDto roleDto = roleService.getRoleById(2);
//        Role role =modelMapper.map(roleDto, Role.class);
//        List<Role> roles = new ArrayList<>();
//        roles.add(role);
//        user.setRoles(roles);
//        userRepo.save(user);

    //}

}
