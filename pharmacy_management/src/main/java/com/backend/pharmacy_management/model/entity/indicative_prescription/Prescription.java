package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
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
}
