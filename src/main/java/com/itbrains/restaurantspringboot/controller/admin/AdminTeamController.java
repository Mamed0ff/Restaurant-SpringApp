package com.itbrains.restaurantspringboot.controller.admin;

import com.itbrains.restaurantspringboot.dtos.chef.ChefCreateDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefUpdateDto;
import com.itbrains.restaurantspringboot.services.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminTeamController {

    @Autowired
    private ChefService chefService;


    @GetMapping("/admin/team")
    public String adminTeam(Model model) {
        List<ChefDto> chefs =chefService.getAllChefs();
        model.addAttribute("chefs", chefs);
        return "admin/team/team";
    }


    @GetMapping("/admin/team/create")
    public String teamCreate(){
        return "admin/team/team-create";
    }


    @PostMapping("/admin/team/create")
    public String teamCreate(@ModelAttribute ChefCreateDto chefCreateDto){
        chefService.addChef(chefCreateDto);
        return "redirect:/admin/team";
    }


    @GetMapping("/admin/team/update/{id}")
    public String teamUpdate(@PathVariable Long id, Model model){
        model.addAttribute("chef",chefService.getChefById(id));
        return "admin/team/team-update";
    }

    @PostMapping("/admin/team/update")
    public String teamUpdate(@ModelAttribute ChefUpdateDto chefUpdateDto){
        chefService.updateChef(chefUpdateDto);
        return "redirect:/admin/team";
    }

    @GetMapping("/admin/team/remove/{id}")
    public String teamRemove(@PathVariable Long id){
        chefService.deleteChef(id);
        return "redirect:/admin/team";
    }

}
