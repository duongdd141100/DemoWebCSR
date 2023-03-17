package com.example.demologincsr.controller;

import com.example.demologincsr.common.BaseResponse;
import com.example.demologincsr.entity.User;
import com.example.demologincsr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/user")
    public ResponseEntity<BaseResponse> getUser() {
        try {
            return ResponseEntity.ok(new BaseResponse("200", "ok", userRepo.findById(1L).get()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse("4xx", e.getMessage(), null));
        }
    }
}
