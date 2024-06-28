package com.itbrains.restaurantspringboot.config;


import com.itbrains.restaurantspringboot.config.auth.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {



    @Autowired
    private CustomUserDetailService userDetailsService;




    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(x->x.disable())
                .authorizeHttpRequests(request-> request
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/home/profile").hasAuthority("USER")
                        .requestMatchers(HttpMethod.POST, "/home/**").authenticated() // Require authentication for all POST requests
                        .requestMatchers("/home/**").permitAll()
                        .anyRequest().permitAll()
                )

                .formLogin(form->form
                        .loginPage("/login")
                        .defaultSuccessUrl("/home")
                );
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public void configure(AuthenticationManagerBuilder auth ) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

}
