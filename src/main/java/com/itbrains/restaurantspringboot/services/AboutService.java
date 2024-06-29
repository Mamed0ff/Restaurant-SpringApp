package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.about.AboutCreate;
import com.itbrains.restaurantspringboot.dtos.about.AboutDto;
import com.itbrains.restaurantspringboot.dtos.about.AboutUpdateDto;

import java.util.List;

public interface AboutService {
    public List<AboutDto> getAll();
    public void create(AboutCreate aboutDto);
    public void update(AboutUpdateDto aboutDto);
    public void delete(Long id);
    public AboutUpdateDto findUpdateAbout(Long id);
}
