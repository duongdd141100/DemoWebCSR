package com.example.demologincsr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_users")
@Data
public class User extends BaseEntity{

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String roles;

}
