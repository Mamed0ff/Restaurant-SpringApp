package com.itbrains.restaurantspringboot.services;

import com.itbrains.restaurantspringboot.dtos.role.RoleDto;
import com.itbrains.restaurantspringboot.models.Role;

import java.util.List;

public interface RoleService {
    public List<RoleDto> getAllRoles();
    public RoleDto getRoleById(Long id);
    Role getRealRoleById(Long id);
}
