package com.backend.pharmacy_management.model.entity.indicative_prescription;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription_indicative")
public class PrescriptionIndicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionIndicativeId;
    @ManyToOne(targetEntity = Prescription.class)
    @JoinColumn(name = "prescription_id")
    private  Prescription prescription;
    @ManyToOne(targetEntity = Indicative.class)
    @JoinColumn(name = "indicative_id")
    private  Indicative indicative;
}
