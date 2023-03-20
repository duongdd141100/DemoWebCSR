package com.example.demologincsr.controller;

import com.example.demologincsr.common.BaseResponse;
import com.example.demologincsr.entity.User;
import com.example.demologincsr.jwt.JwtTokenProvider;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @GetMapping("/login")
    public ResponseEntity<BaseResponse<String>> login(@RequestBody User user) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            user.getUsername(),
                            user.getPassword()
                    )
            );

            Date now = new Date();
            String token = Jwts.builder()
                    .setSubject(user.getUsername())
                    .setIssuedAt(now)
                    .setExpiration(new Date(now.getTime() + 300))
                    .signWith(SignatureAlgorithm.HS512, "javainuse")
                    .compact();
            System.out.println(token);
            return ResponseEntity.ok(new BaseResponse<String>("200", "Success", Jwts.builder()
                    .setId(user.getId().toString())
                    .setSubject(user.getUsername())
                    .setIssuedAt(now)
                    .setExpiration(new Date(now.getTime() + 300))
                    .signWith(SignatureAlgorithm.HS512, "javainuse".getBytes())
                    .compact()));

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse("400", e.getMessage(), null));
        }
    }
}
