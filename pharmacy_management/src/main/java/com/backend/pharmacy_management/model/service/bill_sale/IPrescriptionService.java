package com.backend.pharmacy_management.model.service.bill_sale;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;

import java.util.List;

public interface IPrescriptionService {
    List<Prescription> findAll();

    Prescription findById(int id);

    List<Prescription> search(String fieldSearch, String valueSearch);
}
