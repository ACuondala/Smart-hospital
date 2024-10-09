package com.example.nada.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="blood_groups")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BloodGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String bloodGroup;

    @OneToMany(mappedBy="bloodGroup",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Patient>patients=new ArrayList<>();
}
