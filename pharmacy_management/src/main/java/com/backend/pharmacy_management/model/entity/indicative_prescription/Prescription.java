package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;  // id đơn thuốc
    private String prescriptionCode;  // mã code
    private String prescriptionName;   // tên đơn thuốc
    private String symptom;    // triệu chứng
    private String object;     // đối tượng uống thuốc
    private int numberOfDay;  // số ngày uống
    private  String note;  //  ghi chú
    @JsonBackReference
    @OneToMany(targetEntity = PrescriptionIndicative.class)
    private List<PrescriptionIndicative> prescriptionIndicatives;

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

    public List<PrescriptionIndicative> getPrescriptionIndicatives() {
        return prescriptionIndicatives;
    }

    public void setPrescriptionIndicatives(List<PrescriptionIndicative> prescriptionIndicatives) {
        this.prescriptionIndicatives = prescriptionIndicatives;
    }
}
