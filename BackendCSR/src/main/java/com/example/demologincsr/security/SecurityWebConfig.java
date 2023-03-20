package com.example.demologincsr.security;

import com.example.demologincsr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.stream.Collectors;

@Configuration
public class SecurityWebConfig {

    @Autowired
    private UserRepository userRepo;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(requests -> {
                    try {
                        requests.requestMatchers(HttpMethod.GET, "/api/v1/auth/login").permitAll()
                                .anyRequest().authenticated().and().oauth2ResourceServer().jwt();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .formLogin().permitAll()
                .and().logout().permitAll().and().build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(userRepo.findAll()
                .stream().map(user -> User.withDefaultPasswordEncoder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .roles(user.getRoles()).build()).collect(Collectors.toList()));
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return new ProviderManager((AuthenticationProvider) authenticationConfiguration);
    }
}
