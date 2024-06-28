package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.chef.*;
import com.itbrains.restaurantspringboot.models.Chef;

import java.util.List;

public interface ChefService {
    public void addChef(ChefCreateDto chefCreateDto);
    public void updateChef(ChefUpdateDto chefUpdateDto);
    public void deleteChef(Long chefId);
    public ChefDto getChefById(Long chefId);
    public List<ChefDto> getAllChefs();
    public List<DeletedChefDto> getAllDeletedChefs();
    Chef getRealChefById(Long chefId);
    List<ChefShowDto> findTop4ByOrderByIdAsc();
}
