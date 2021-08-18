package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug,Long> {
}
