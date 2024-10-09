package com.example.nada.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="insuranceCompany")
@Getter
@NoArgsConstructor
public class InsuranceCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Setter
    private UUID id;
    @Setter
    private String name;
    @Setter
    private Integer nif;
    @Setter
    private String email;
    @Setter
    private String responsible;
    @Setter
    private Integer contact;
    @Setter
    private String address;
    @Setter
    private String code;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "kindOfInsurance_id")
    @Setter
    private KindOfInsurance kind;

    @OneToMany(mappedBy = "insuranceCompany", cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Patient> patients;


}
