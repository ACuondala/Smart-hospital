package com.example.nada.models;

import jakarta.persistence.*;

@Entity
@Table(name="civil_state")
public class CivilState {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
