package com.example.nada.dtos.insuranceDtos;

import com.example.nada.dtos.KindOfInsuranceDtos.KindOfInsuranceDto;

public record InsertInsuranceCompanyDto(
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
