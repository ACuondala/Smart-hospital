package com.example.nada.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name="blood_group")
    private String bloodGroup;
}
