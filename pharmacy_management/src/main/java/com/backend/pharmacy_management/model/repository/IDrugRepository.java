package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugRepository extends JpaRepository<Drug,Long> {
}
