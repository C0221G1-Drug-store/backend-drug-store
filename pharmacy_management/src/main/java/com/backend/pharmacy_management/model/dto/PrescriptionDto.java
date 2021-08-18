package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class PrescriptionDto {
    private Long prescriptionId;
    @NotBlank
    private String prescriptionCode;
    @NotBlank
    private String prescriptionName;
    @NotBlank
    private String symptom;
    @NotBlank
    private String object;
    @NotBlank
    private int numberOfDay;

    private  String note;

    private List<Indicative> indicatives;

    public PrescriptionDto() {
    }

    public PrescriptionDto(Long prescriptionId, @NotBlank String prescriptionCode, @NotBlank String prescriptionName,
                           @NotBlank String symptom, @NotBlank String object, @NotBlank int numberOfDay, String note, List<Indicative> indicatives) {
        this.prescriptionId = prescriptionId;
        this.prescriptionCode = prescriptionCode;
        this.prescriptionName = prescriptionName;
        this.symptom = symptom;
        this.object = object;
        this.numberOfDay = numberOfDay;
        this.note = note;
        this.indicatives = indicatives;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public String getPrescriptionCode() {
        return prescriptionCode;
    }

    public void setPrescriptionCode(String prescriptionCode) {
        this.prescriptionCode = prescriptionCode;
    }

    public String getPrescriptionName() {
        return prescriptionName;
    }

    public void setPrescriptionName(String prescriptionName) {
        this.prescriptionName = prescriptionName;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(int numberOfDay) {
        this.numberOfDay = numberOfDay;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Indicative> getIndicatives() {
        return indicatives;
    }

    public void setIndicatives(List<Indicative> indicatives) {
        this.indicatives = indicatives;
    }
}
