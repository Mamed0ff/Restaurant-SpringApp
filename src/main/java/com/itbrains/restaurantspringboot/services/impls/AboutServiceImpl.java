package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.about.AboutCreate;
import com.itbrains.restaurantspringboot.dtos.about.AboutDto;
import com.itbrains.restaurantspringboot.dtos.about.AboutUpdateDto;
import com.itbrains.restaurantspringboot.models.About;
import com.itbrains.restaurantspringboot.repos.AboutRepository;
import com.itbrains.restaurantspringboot.services.AboutService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutRepository aboutRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<AboutDto> getAll() {
        List<About> abouts = aboutRepository.findAll();
        List<AboutDto> aboutDtos = abouts.stream().filter(about -> !about.isDeleted()).map(about -> modelMapper
                .map(about, AboutDto.class)).collect(Collectors.toList());
        return aboutDtos;
    }

    @Override
    public void create(AboutCreate aboutDto) {
        About about=modelMapper.map(aboutDto, About.class);
        aboutRepository.save(about);

    }

    @Override
    public void update(AboutUpdateDto aboutDto) {
        About about = aboutRepository.findById(aboutDto.getId()).orElseThrow();
        modelMapper.map(aboutDto, about);
        aboutRepository.save(about);

    }

    @Override
    public void delete(Long id) {
        About about =aboutRepository.findById(id).orElseThrow();
        about.setDeleted(true);
        aboutRepository.save(about);


    }

    @Override
    public AboutUpdateDto findUpdateAbout(Long id) {
        About about = aboutRepository.findById(id).orElseThrow();
        AboutUpdateDto aboutDto = modelMapper.map(about, AboutUpdateDto.class);
        return aboutDto;
    }
}
