package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.chef.ChefCreateDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefDto;
import com.itbrains.restaurantspringboot.dtos.chef.ChefUpdateDto;
import com.itbrains.restaurantspringboot.dtos.chef.DeletedChefDto;
import com.itbrains.restaurantspringboot.models.Chef;
import com.itbrains.restaurantspringboot.repos.ChefRepository;
import com.itbrains.restaurantspringboot.services.ChefService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChefServiceImpl implements ChefService {
    @Autowired
    private ChefRepository chefRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void addChef(ChefCreateDto chefCreateDto) {
        Chef chef= modelMapper.map(chefCreateDto, Chef.class);
        chef.setJoinedDate(new Date());
        chefRepository.save(chef);

    }

    @Override
    public void updateChef(ChefUpdateDto chefUpdateDto) {
        Chef chef=chefRepository.findById(chefUpdateDto.getId()).orElseThrow();
        chef.setName(chefUpdateDto.getName());
        chef.setSurname(chefUpdateDto.getSurname());
        chef.setPhotoUrl(chefUpdateDto.getPhotoUrl());
        chef.setSpeciality(chefUpdateDto.getSpeciality());
        chefRepository.save(chef);

    }

    @Override
    public void deleteChef(Long chefId) {
        Chef chef = chefRepository.findById(chefId).orElseThrow();
        chef.setHere(false);
        chefRepository.save(chef);

    }

    @Override
    public ChefDto getChefById(Long chefId) {
        Chef chef = chefRepository.findById(chefId).orElseThrow();
        return modelMapper.map(chef,ChefDto.class);
    }

    @Override
    public List<ChefDto> getAllChefs() {
        List<Chef> chefs = chefRepository.findAll();
        List<ChefDto> chefDtos = chefs.stream().filter(x-> x.isHere() ==true).map(chef->modelMapper.map(chef,ChefDto.class)).collect(Collectors.toList());
        return chefDtos;
    }

    @Override
    public List<DeletedChefDto> getAllDeletedChefs() {
        List<Chef> chefs = chefRepository.findAll();
        List<DeletedChefDto> chefDeletedDtos = chefs.stream().filter(x-> x.isHere() ==false).map(chef->modelMapper.map(chef,DeletedChefDto.class)).collect(Collectors.toList());
        return chefDeletedDtos;
    }
}
