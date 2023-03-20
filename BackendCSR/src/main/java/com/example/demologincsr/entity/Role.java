package com.example.demologincsr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_roles")
@Data
public class Role extends BaseEntity{

    @Column
    private String name;
}
