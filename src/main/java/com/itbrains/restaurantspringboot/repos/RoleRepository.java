package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
