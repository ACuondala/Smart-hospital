package com.example.nada.controllers;

import com.example.nada.dtos.insuranceDtos.InsertInsuranceCompanyDto;
import com.example.nada.dtos.insuranceDtos.InsuranceCompanyDto;
import com.example.nada.services.InsuranceCompanyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value="/insuranceCompanies")
@Tag(name = "Insurance Company")
public class InsuranceCompanyController {

    @Autowired
    private InsuranceCompanyService insurance;

    @Operation(summary = "Show all insurance")
    @GetMapping
    public ResponseEntity<List<InsuranceCompanyDto>> index(){
        List<InsuranceCompanyDto> insurances= insurance.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(insurances);
    }

    @Operation(summary = "create a new Insurance insurance")
    @PostMapping
    public ResponseEntity<InsuranceCompanyDto> store(@RequestBody InsertInsuranceCompanyDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(insurance.save(dto));
    }

    @Operation(summary="alter a specific insurance company")
    @GetMapping(value = "/{id}")
    public ResponseEntity<InsuranceCompanyDto> show(@PathVariable UUID id){
        InsuranceCompanyDto insuranceCompany=insurance.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(insuranceCompany);
    }
    @Operation(summary="Update an existing insurance company")
    @PutMapping(value="/{id}")
    public ResponseEntity<InsuranceCompanyDto>store(@PathVariable UUID id, @RequestBody InsertInsuranceCompanyDto  dto){
        InsuranceCompanyDto insuranceCompanyDto= insurance.update(id,dto);
        return ResponseEntity.status(HttpStatus.OK).body(insuranceCompanyDto);
    }

    @Operation(summary="delete an existing insurance company")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<InsuranceCompanyDto>destroy(@PathVariable UUID id){
        insurance.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
