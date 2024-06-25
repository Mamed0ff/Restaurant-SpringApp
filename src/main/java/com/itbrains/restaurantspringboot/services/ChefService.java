package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.chef.ChefCreateDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefUpdateDto;
import com.itbrains.restaurantspringboot.dtos.chef.DeletedChefDto;

import java.util.List;

public interface ChefService {
    public void addChef(ChefCreateDto chefCreateDto);
    public void updateChef(ChefUpdateDto chefUpdateDto);
    public void deleteChef(Long chefId);
    public ChefDto getChefById(Long chefId);
    public List<ChefDto> getAllChefs();
    public List<DeletedChefDto> getAllDeletedChefs();
}
