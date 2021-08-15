package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.indicative_prescription.PrescriptionIndicative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrescriptionIndicativeRepository extends JpaRepository<PrescriptionIndicative,Long> {
}
