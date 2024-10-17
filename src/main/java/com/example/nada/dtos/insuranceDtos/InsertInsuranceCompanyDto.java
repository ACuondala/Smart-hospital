package com.example.nada.dtos.insuranceDtos;

import com.example.nada.dtos.KindOfInsuranceDtos.KindOfInsuranceDto;

public record InsertInsuranceCompanyDto(
        String name,
        Integer nif,
        String code,
        String address,
        Integer contact,
        String email,
        String responsible,
        KindOfInsuranceDto kind

) {
}
