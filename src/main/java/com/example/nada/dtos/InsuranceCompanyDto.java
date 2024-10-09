package com.example.nada.dtos;

import com.example.nada.models.KindOfInsurance;
import com.example.nada.models.Patient;
import java.util.List;

import java.util.UUID;

public record InsuranceCompanyDto(
        UUID id,
        String name,
        Integer nif,
        String email,
        String responsible,
        Integer contact,
        String address,
        String code,
        KindOfInsuranceDto kind,
        List<PatientDto>patients


) {
}
