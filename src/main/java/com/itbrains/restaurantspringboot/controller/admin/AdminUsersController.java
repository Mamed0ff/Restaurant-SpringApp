package com.itbrains.restaurantspringboot.controller.admin;

import com.itbrains.restaurantspringboot.dtos.user.UserDto;
import com.itbrains.restaurantspringboot.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminUsersController {


    @Autowired
    private UserEntityService userEntityService;

    @GetMapping("/admin/users")
    public String adminUsers(Model model) {
        List<UserDto> users = userEntityService.findAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }
}
