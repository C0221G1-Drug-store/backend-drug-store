package com.backend.pharmacy_management.model.entity.indicative_prescription;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Getter
@Setter
@Table(name = "indicative")
public class Indicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long indicativeId;
    private Long totalPill;
    private Long drinkDay;
    private Long drinkTime;
    private String drug;
    @ManyToOne
    @JoinColumn(name = "prescription_id ", referencedColumnName = "prescriptionId")
    private  Prescription prescription;

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
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
}
