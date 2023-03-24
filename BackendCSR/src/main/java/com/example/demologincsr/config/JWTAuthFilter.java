package com.example.demologincsr.config;

import com.example.demologincsr.common.ErrorMessageEnum;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

    @Autowired
    private UserAuthProvider userAuthProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.hasText(token)) {
            try {
                SecurityContextHolder.getContext().setAuthentication(userAuthProvider.validateToken(token.split(" ")[1]));
            } catch (Exception e) {
                throw new RuntimeException(ErrorMessageEnum.TOKEN_INVALID.getCode());
            }
        }
        filterChain.doFilter(request, response);
    }
}
