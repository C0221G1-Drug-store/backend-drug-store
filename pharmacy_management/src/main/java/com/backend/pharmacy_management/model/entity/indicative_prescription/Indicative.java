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
}
