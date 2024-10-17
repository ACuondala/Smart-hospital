package com.example.nada.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="civil_state")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CivilState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy="civilState",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Patient> patients= new ArrayList<>();
}
