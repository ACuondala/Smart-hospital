package com.example.nada.repositories;

import com.example.nada.models.InsuranceCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany,UUID> {
}
