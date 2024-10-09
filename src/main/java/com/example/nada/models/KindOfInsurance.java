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
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KindOfInsurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "kind", cascade = CascadeType.ALL,orphanRemoval=true)
    private List<InsuranceCompany> insuranceCompany;
}
