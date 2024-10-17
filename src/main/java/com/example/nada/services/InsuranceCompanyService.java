package com.example.nada.services;

import com.example.nada.dtos.insuranceDtos.InsertInsuranceCompanyDto;
import com.example.nada.dtos.insuranceDtos.InsuranceCompanyDto;
import com.example.nada.mappers.InsuranceCompanyMapper;
import com.example.nada.models.InsuranceCompany;
import com.example.nada.repositories.InsuranceCompanyRepository;
import com.example.nada.services.exceptions.EntitiesNotFoundException;
import com.example.nada.services.exceptions.IntegityException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
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

    @Transactional
    public InsuranceCompanyDto save(InsertInsuranceCompanyDto dto) {
        InsuranceCompany insuranceCompany= new InsuranceCompany();
        // Converte o DTO para entidade
        InsuranceCompanyMapper.dtoToInsuranceCompany(insuranceCompany,dto);
        // Salva a entidade no repositório
        insuranceCompany=insurance.save(insuranceCompany);

        // Converte a entidade salva de volta para DTO e retorna
        return InsuranceCompanyMapper.InsuranceToDto(insuranceCompany);


    }

    @Transactional
    public InsuranceCompanyDto getOne(UUID id) {
        Optional<InsuranceCompany> insuranceCompany= insurance.findById(id);
        InsuranceCompany insurance=insuranceCompany.orElseThrow(()-> new EntitiesNotFoundException("This insurance Company id: "+id+" doesn't exist"));
        return InsuranceCompanyMapper.InsuranceToDto(insurance);
    }

    @Transactional
    public InsuranceCompanyDto update(UUID id, InsertInsuranceCompanyDto  dto) {

        try {
            InsuranceCompany insurances=insurance.getReferenceById(id);
            InsuranceCompanyMapper.dtoToInsuranceCompany(insurances,dto);
            insurances=insurance.save(insurances);
            return InsuranceCompanyMapper.InsuranceToDto(insurances);
        }catch(EntityNotFoundException e){
            throw new EntitiesNotFoundException("This insurance Company id: "+id+" doesn't exist");
        }
    }

    @Transactional
    public void delete(UUID id) {
        try {

            InsuranceCompany insuranceCompany = insurance.findById(id)
                    .orElseThrow(() -> new EntitiesNotFoundException("This insurance Company id: " + id + " doesn't exist"));

            // Tenta deletar a entidade encontrada
            insurance.delete(insuranceCompany);

        } catch (DataIntegrityViolationException e) {

            throw new IntegityException("This insurance Company id: " + id + " has related child entities and cannot be deleted");
        }
    }
}
