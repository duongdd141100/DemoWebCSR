package com.example.demologincsr.controller;

import com.example.demologincsr.common.BaseResponse;
import com.example.demologincsr.config.UserAuthProvider;
import com.example.demologincsr.entity.User;
import com.example.demologincsr.model.CustomUserDetails;
import com.example.demologincsr.repository.UserRepository;
import com.example.demologincsr.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    private UserAuthProvider userAuthProvider;

    @Autowired
    private AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<BaseResponse<String>> signIn(@AuthenticationPrincipal User user) {
        try {

            return ResponseEntity.ok(new BaseResponse<>("200", "ok", userAuthProvider.createToken(user.getUsername())));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse("400", e.getMessage(), null));
        }
    }

    @GetMapping("/ping")
    public ResponseEntity<BaseResponse<String>> ping() {
        return ResponseEntity.ok(new BaseResponse<>("200", "ok", "pong"));
    }

    @PostMapping("/sign-up")
    public ResponseEntity<BaseResponse<User>> signUp(@RequestBody User user) {
        try {
            return ResponseEntity.ok(new BaseResponse<>("200", "ok", authService.save(user)));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse<>("400", "ERROR", null));
        }
    }
}
