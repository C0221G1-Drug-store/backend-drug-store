package com.backend.pharmacy_management.model.service.prescription_indicative;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPrescriptionService extends IGeneralService<Prescription> {
    Page<Prescription> getAllPrescriptionList(Pageable pageable);
    Page<Prescription> searchPrescription(String prescriptionName, String prescriptionCode, String object , String symptom , Pageable pageable);
}
