package com.example.nada.models;

import jakarta.persistence.*;

@Entity
@Table(name="genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String gender;
}
