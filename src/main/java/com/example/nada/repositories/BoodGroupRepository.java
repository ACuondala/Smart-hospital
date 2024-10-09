package com.example.nada.repositories;

import com.example.nada.models.BloodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoodGroupRepository extends JpaRepository<BloodGroup,Long> {
}
