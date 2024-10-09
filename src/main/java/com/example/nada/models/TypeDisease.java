package com.example.nada.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "type_disease")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeDisease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy="typeOfDisease")
    private Set<Patient> patients= new HashSet<>();
}
