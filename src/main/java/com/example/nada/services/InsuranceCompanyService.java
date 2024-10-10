package com.example.nada.services;

import com.example.nada.dtos.insuranceDtos.InsertInsuranceCompanyDto;
import com.example.nada.dtos.insuranceDtos.InsuranceCompanyDto;
import com.example.nada.mappers.InsuranceCompanyMapper;
import com.example.nada.models.InsuranceCompany;
import com.example.nada.repositories.InsuranceCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceCompanyService {

    @Autowired
    private InsuranceCompanyRepository insurance;

    @Transactional(readOnly = true)
    public List<InsuranceCompanyDto> getAll() {
        List<InsuranceCompany> insurances= insurance.findAll();
        return insurances.stream().map(InsuranceCompanyMapper::InsuranceToDto).collect(Collectors.toList());
    }


    public InsuranceCompanyDto save(InsertInsuranceCompanyDto dto) {
        // Converte o DTO para entidade
        InsuranceCompany insurances= InsuranceCompanyMapper.dtoToInsuranceCompany(dto);
        // Salva a entidade no repositório
        insurances=insurance.save(insurances);

        // Converte a entidade salva de volta para DTO e retorna
        return InsuranceCompanyMapper.InsuranceToDto(insurances);


    }
}
