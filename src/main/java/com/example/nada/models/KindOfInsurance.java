package com.example.nada.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="kindOfInsurance")
@Getter

@NoArgsConstructor

public class KindOfInsurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter
    private Long id;

    @Setter
    private String name;

    @OneToMany(mappedBy = "kind", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<InsuranceCompany> insuranceCompany;

    public KindOfInsurance(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public KindOfInsurance(Long id) {
        this.id = id;

    }
}
