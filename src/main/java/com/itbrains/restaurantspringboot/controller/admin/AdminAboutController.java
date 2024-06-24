package com.itbrains.restaurantspringboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminAboutController {

    @GetMapping("/admin/about")
    public String admin() {
        return "admin/about";
    }
}
