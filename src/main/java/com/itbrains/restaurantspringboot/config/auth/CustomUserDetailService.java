package com.itbrains.restaurantspringboot.config.auth;

import com.itbrains.restaurantspringboot.models.UserEntity;
import com.itbrains.restaurantspringboot.repos.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserEntityRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = userRepository.findByEmail(username);
        if(user!=null){
            User loginUser = new User(
                    user.getEmail(),
                    user.getPassword(),
                    user.isEmailConfirmed(),
                    true,
                    true,
                    true,
                    user.getRoles().stream().map(m-> new SimpleGrantedAuthority(m.getName())).collect(Collectors.toList())

            );
            return loginUser;
        }
        else {
            throw new UsernameNotFoundException("User not found with username " + username);
        }
    }
}
