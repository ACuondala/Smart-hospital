package com.example.nada.repositories;

import com.example.nada.models.KindOfInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KindOfInsuranceRepository extends JpaRepository<KindOfInsurance,Long> {
}
