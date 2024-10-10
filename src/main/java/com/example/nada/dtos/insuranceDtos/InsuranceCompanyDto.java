package com.example.nada.dtos.insuranceDtos;

import com.example.nada.dtos.KindOfInsuranceDtos.KindOfInsuranceDto;

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
        KindOfInsuranceDto kind



) {
}
