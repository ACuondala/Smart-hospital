package com.example.nada.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;
    private String name;
    private Instant dob;
    private String identificationNumber;
    private String email;
    private Integer phone;
    private Integer otherPhone;
    private String profission;
    private Integer insurancePercent;
    private String address;
    private String description;
    private String allergy;
    private String img;
    private String doc;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="civilstate_id")
    private CivilState civilState;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="gender_id")
    private Gender gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id")
    private InsuranceCompany insuranceCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    private BloodGroup bloodGroup;

    @ManyToMany
    @JoinTable(name="patient_typeOfDisease",
            joinColumns = @JoinColumn(name="patient_id"),
            inverseJoinColumns=@JoinColumn(name="typeOfDisease_id")
    )
    private Set<TypeDisease>typeOfDisease= new HashSet<>();

}
