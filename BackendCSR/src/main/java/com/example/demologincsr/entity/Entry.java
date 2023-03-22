package com.example.demologincsr.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_entries")
@Data
public class Entry extends BaseEntity{

    @Column(name = "slug")
    private String slug;

    @Column(name = "label")
    private String label;

}
