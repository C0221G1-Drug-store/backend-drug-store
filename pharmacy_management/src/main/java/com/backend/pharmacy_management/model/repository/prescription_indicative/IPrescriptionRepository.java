package com.backend.pharmacy_management.model.repository.prescription_indicative;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrescriptionRepository extends JpaRepository<Prescription,Long> {
    @Query(value="select prescription_code,prescription_name,object,symptom,note " +
            " from pharmacy_management.prescription " +
            " where prescription_code like %?1% " +
            " and prescription_name like %?2%" +
            " and object like %?3%" +
            " and  symptom  like %?4%"
            ,nativeQuery = true)
    Page<Prescription> findByPrescriptionFilter(String prescriptionName, String prescriptionCode, String object , String symptom , Pageable pageable);

}
