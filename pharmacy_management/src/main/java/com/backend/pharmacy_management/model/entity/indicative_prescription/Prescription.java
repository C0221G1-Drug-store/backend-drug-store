package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionId;
    private String prescriptionCode;
    private String prescriptionName;
    private String symptom;
    private String object;
    private int numberOfDay;
    private  String note;
    @JsonBackReference(value = "prescription-prescription_indicative")
    @OneToMany(mappedBy = "prescription")
    private List<PrescriptionIndicative> prescriptionIndicatives;
    @JsonBackReference(value = "drug_of_bill-prescription_indicative")
    @OneToMany(mappedBy = "prescription")
    private List<DrugOfBill> drugOfBills;
}
