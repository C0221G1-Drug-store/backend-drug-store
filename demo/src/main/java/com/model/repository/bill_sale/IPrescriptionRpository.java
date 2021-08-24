package com.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.model.entity.indicative_prescription.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPrescriptionRpository extends JpaRepository<Prescription, Long> {

    //TamLN
    @Query(value = "select * from prescription where prescription_id = ?;", nativeQuery = true)
    Prescription findById(int id);
    @Query(value = "select * from prescription where prescription_name like ?", nativeQuery = true)
    List<Prescription> findpres(String valueSearch);

    @Query(value = "select * from prescription where symptom like ?", nativeQuery = true)
    List<Prescription> findBySign(String s);
}
