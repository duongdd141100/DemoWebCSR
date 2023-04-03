package com.example.demologincsr.config;

import com.example.demologincsr.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig {

    @Autowired
    private FilterExceptionHandler filterExceptionHandler;

    @Autowired
    private UsernamePasswordAuthFilter userPassAuthFilter;

    @Autowired
    private JWTAuthFilter jwtAuthFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable()
                .addFilterBefore(userPassAuthFilter, BasicAuthenticationFilter.class)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthFilter.class)
                .addFilterBefore(filterExceptionHandler, JWTAuthFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(requests ->
                        requests.requestMatchers(HttpMethod.POST,
                                Constants.SIGN_IN_API, Constants.SIGN_UP_API, Constants.SIGN_OUT_API).permitAll()
                                .anyRequest().authenticated());
        return http.build();
    }
}
