package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription,Long> {
//    @Query(value="select prescription_code,prescription_name,object,symptom,note from prescription where  ",nativeQuery = true)
//    Page<Prescription> findByFilter(String filter, String name);

}
