package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription_indicative")
public class PrescriptionIndicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionIndicativeId;
    @ManyToOne(targetEntity = Prescription.class)
    @JoinColumn(name = "prescription_id")
    @JsonBackReference(value = "prescription-prescription_indicative")
    private  Prescription prescription;
    @ManyToOne(targetEntity = Indicative.class)
    @JoinColumn(name = "indicative_id")
    @JsonBackReference(value = "indicative-prescription_indicative")
    private  Indicative indicative;
}
