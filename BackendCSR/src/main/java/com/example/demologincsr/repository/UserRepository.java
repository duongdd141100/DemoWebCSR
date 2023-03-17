package com.example.demologincsr.repository;

import com.example.demologincsr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
