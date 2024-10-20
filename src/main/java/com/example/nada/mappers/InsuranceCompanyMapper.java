package com.example.nada.mappers;

import com.example.nada.dtos.KindOfInsuranceDtos.KindOfInsuranceDto;
import com.example.nada.dtos.insuranceDtos.InsertInsuranceCompanyDto;
import com.example.nada.dtos.insuranceDtos.InsuranceCompanyDto;
import com.example.nada.models.InsuranceCompany;
import com.example.nada.models.KindOfInsurance;

public class InsuranceCompanyMapper {


    // Método para converter de entidade para DTO
    // Listar as seguradoras
    public static InsuranceCompanyDto InsuranceToDto(InsuranceCompany insurance){
        return new InsuranceCompanyDto(
                insurance.getId(),
                insurance.getName(),
                insurance.getNif(),
                insurance.getEmail(),
                insurance.getResponsible(),
                insurance.getContact(),
                insurance.getAddress(),
                insurance.getCode(),
               toKindOInsuranceDto(
                       insurance.getKind()
               )
        );
    }

    // Método auxiliar para converter KindOfInsurance para KindOfInsuranceDto
    private static KindOfInsuranceDto toKindOInsuranceDto(KindOfInsurance kind){
        return new KindOfInsuranceDto(
                kind.getId(),
                kind.getName()
        );
    }


    // Método para converter de DTO para entidade (opcional)
    //Inserir um novo registro na BD
    public static void dtoToInsuranceCompany(InsuranceCompany insuranceCompany, InsertInsuranceCompanyDto dto) {
        KindOfInsurance kind = new KindOfInsurance(dto.kind().id(), dto.kind().name());

        // Atualiza os campos da entidade existente com os valores do DTO
        insuranceCompany.setName(dto.name());
        insuranceCompany.setNif(dto.nif());
        insuranceCompany.setCode(dto.code());
        insuranceCompany.setAddress(dto.address());
        insuranceCompany.setContact(dto.contact());
        insuranceCompany.setEmail(dto.email());
        insuranceCompany.setResponsible(dto.responsible());
        insuranceCompany.setKind(kind);
    }
}
