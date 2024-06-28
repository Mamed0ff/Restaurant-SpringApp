package com.itbrains.restaurantspringboot.services.impls;

import com.itbrains.restaurantspringboot.dtos.role.RoleDto;
import com.itbrains.restaurantspringboot.models.Role;
import com.itbrains.restaurantspringboot.repos.RoleRepository;
import com.itbrains.restaurantspringboot.services.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<RoleDto> getAllRoles() {
        List<Role> roles = roleRepository.findAll();
        List<RoleDto> roleDtos = roles.stream().map(role -> modelMapper.map(role,RoleDto.class)).collect(Collectors.toList());
        return roleDtos;

    }

    @Override
    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow();

        return modelMapper.map(role,RoleDto.class);
    }

    @Override
    public Role getRealRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }
}
