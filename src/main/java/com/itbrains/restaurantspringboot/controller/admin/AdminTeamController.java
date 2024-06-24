package com.itbrains.restaurantspringboot.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminTeamController {
    @GetMapping("/admin/team")
    public String adminTeam() {
        return "admin/team/team";
    }
}
