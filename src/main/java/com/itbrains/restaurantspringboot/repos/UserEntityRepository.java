package com.itbrains.restaurantspringboot.repos;

import com.itbrains.restaurantspringboot.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    public UserEntity findByEmail(String email);
}
