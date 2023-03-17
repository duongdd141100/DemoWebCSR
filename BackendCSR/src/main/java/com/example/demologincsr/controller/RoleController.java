package com.example.demologincsr.controller;

import com.example.demologincsr.entity.Role;
import com.example.demologincsr.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/add")
    public ResponseEntity<Object> addRole(@RequestBody Role role) {
        try {
            System.out.println(role.getName());
            return ResponseEntity.ok(roleRepository.save(role));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}
