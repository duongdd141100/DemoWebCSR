package com.example.demologincsr.service;

import com.example.demologincsr.entity.User;

public interface AuthService {
    User findByUsername(String username);

    User validateUser(User user);

    User save(User user);
}
