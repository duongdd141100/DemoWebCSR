package com.example.demologincsr.service.impl;

import com.example.demologincsr.entity.User;
import com.example.demologincsr.repository.UserRepository;
import com.example.demologincsr.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.nio.CharBuffer;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        if (StringUtils.hasText(username)) {
            return userRepo.findByUsername(username);
        }
        throw new RuntimeException("User Not Found!");
    }

    @Override
    public User validateUser(User user) {
        if (user != null && StringUtils.hasText(user.getUsername())) {
            User realUser = userRepo.findByUsername(user.getUsername());
            if (passwordEncoder.matches(CharBuffer.wrap(user.getPassword()), realUser.getPassword())) {
                return realUser;
            }
        }
        throw new RuntimeException("User Not Valid!");

    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
