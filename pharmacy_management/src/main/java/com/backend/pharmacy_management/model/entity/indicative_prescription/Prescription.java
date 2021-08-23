package com.backend.pharmacy_management.model.entity.indicative_prescription;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity

@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    @Column(unique = true)
    private String prescriptionCode;
    private String prescriptionName;
    private String symptom;
    private String object;
    private int numberOfDay;
    private  String note;
    private  boolean flag;
    @JsonBackReference
    @OneToMany(mappedBy = "prescription")
    private List<Indicative> indicatives;

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Indicative> getIndicatives() {
        return indicatives;
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

    public boolean isFlag() {
        return flag;
    }

    public void setIndicatives(List<Indicative> indicatives) {
        this.indicatives = indicatives;
    }
}
