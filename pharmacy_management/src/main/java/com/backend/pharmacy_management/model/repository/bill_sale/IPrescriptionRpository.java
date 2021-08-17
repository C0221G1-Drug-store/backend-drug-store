package com.backend.pharmacy_management.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPrescriptionRpository extends JpaRepository<Prescription, Long> {
    @Query(value = "select * from prescription where id = ?;", nativeQuery = true)
    Prescription findById(int id);
}
