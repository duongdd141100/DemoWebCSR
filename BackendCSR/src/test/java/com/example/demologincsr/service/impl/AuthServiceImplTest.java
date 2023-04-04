package com.example.demologincsr.service.impl;

import com.example.demologincsr.entity.User;
import com.example.demologincsr.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AuthServiceImplTest {

    @SpyBean
    private AuthServiceImpl authService;

    @MockBean
    private UserRepository userRepo;



    @Test
    void findByUsername() {
        User user = new User();
        user.setUsername("DuongDD");
        user.setPassword("1111");
        Mockito.when(userRepo.findByUsername(user.getUsername())).thenReturn(user);
        Mockito.doNothing().when(userRepo).deleteAll();
        User userResult = authService.findByUsername(user.getUsername());

        Assertions.assertEquals(user.getPassword(), userResult.getPassword());
    }
}