package com.itbrains.restaurantspringboot.controller.admin;

import com.itbrains.restaurantspringboot.dtos.about.AboutCreate;
import com.itbrains.restaurantspringboot.dtos.about.AboutDto;
import com.itbrains.restaurantspringboot.dtos.about.AboutUpdateDto;
import com.itbrains.restaurantspringboot.models.About;
import com.itbrains.restaurantspringboot.services.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminAboutController {

    @Autowired
    private AboutService aboutService;

    @GetMapping("/admin/about")
    public String admin(Model model) {
        List<AboutDto> aboutDtos = aboutService.getAll();
        model.addAttribute("abouts", aboutDtos);
        return "admin/about/about";
    }

    @GetMapping("/admin/about/remove/{id}")
    public String adminDelete(@PathVariable Long id) {
        aboutService.delete(id);
        return "redirect:/admin/about";
    }

    @GetMapping("/admin/about/create")
    public String create() {
        return "admin/about/about-create";
    }

    @PostMapping("/admin/about/create")
    public String createSubmit(@ModelAttribute() AboutCreate aboutDto) {
        aboutService.create(aboutDto);
        return "redirect:/admin/about";
    }

    @GetMapping("/admin/about/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        AboutUpdateDto about=aboutService.findUpdateAbout(id);
        model.addAttribute("about",about);
        return "admin/about/about-update";
    }
    @PostMapping("/admin/about/update")
    public String update(AboutUpdateDto aboutDto) {
        aboutService.update(aboutDto);
        return "redirect:/admin/about";
    }
}
