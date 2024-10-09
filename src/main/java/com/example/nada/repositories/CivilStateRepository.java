package com.example.nada.repositories;

import com.example.nada.models.CivilState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CivilStateRepository extends JpaRepository<CivilState,Long> {
}
