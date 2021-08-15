package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPrescriptionService extends IGeneralService<Prescription> {
    Page<Prescription> getAllPrescriptionList(Pageable pageable);

}
