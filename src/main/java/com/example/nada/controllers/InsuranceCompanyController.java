package com.example.nada.controllers;

import com.example.nada.dtos.insuranceDtos.InsertInsuranceCompanyDto;
import com.example.nada.dtos.insuranceDtos.InsuranceCompanyDto;
import com.example.nada.services.InsuranceCompanyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name="/insuranceCompanies")
@Tag(name = "Insurance Company")
public class InsuranceCompanyController {

    @Autowired
    private InsuranceCompanyService insurance;

    @GetMapping
    public ResponseEntity<List<InsuranceCompanyDto>> index(){
        List<InsuranceCompanyDto> insurances= insurance.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(insurances);
    }

    @PostMapping
    public ResponseEntity<InsuranceCompanyDto> store(@RequestBody InsertInsuranceCompanyDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(insurance.save(dto));
    }
}
