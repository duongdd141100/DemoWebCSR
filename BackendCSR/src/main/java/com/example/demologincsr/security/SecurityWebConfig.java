package com.example.demologincsr.security;

import com.example.demologincsr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig {

    @Autowired
    private UserRepository userRepo;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((requests) -> requests
                .anyRequest().authenticated())
                .formLogin().permitAll()
                .and()
                .logout((logout) -> logout.permitAll());
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(userRepo.findAll()
                .stream().map(user -> User.withDefaultPasswordEncoder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRoles()).build()).collect(Collectors.toList()));
    }
}
