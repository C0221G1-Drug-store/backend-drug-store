package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "indicative")
public class Indicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long indicativeId;
    private Long totalPill;
    private Long drinkDay;
    private Long drinkTime;
//    @ManyToOne
//    @JoinColumn(name = "drug_id")
//    @JsonManagedReference
//    private Drug drug;
    private String drug;

    @ManyToOne
    @JoinColumn(name = "prescription_id ", referencedColumnName = "prescriptionId")
    private  Prescription prescription;

    public Indicative() {
    }

    public Long getIndicativeId() {
        return indicativeId;
    }

    public void setIndicativeId(Long indicativeId) {
        this.indicativeId = indicativeId;
    }

    public Long getTotalPill() {
        return totalPill;
    }

    public void setTotalPill(Long totalPill) {
        this.totalPill = totalPill;
    }

    public Long getDrinkDay() {
        return drinkDay;
    }

    public void setDrinkDay(Long drinkDay) {
        this.drinkDay = drinkDay;
    }

    public Long getDrinkTime() {
        return drinkTime;
    }

    public void setDrinkTime(Long drinkTime) {
        this.drinkTime = drinkTime;
    }

    public String getDrug() {
        return drug;
    }

    public void setDrug(String drug) {
        this.drug = drug;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
