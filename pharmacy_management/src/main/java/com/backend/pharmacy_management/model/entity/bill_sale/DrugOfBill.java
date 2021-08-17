package com.backend.pharmacy_management.model.entity.bill_sale;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "drug_of_bill")
public class DrugOfBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_of_bill_id")
    private Long drugOfBillId;
    @ManyToOne
    @JoinColumn(name = "drug_id", nullable = false)
    @JsonBackReference(value = "drug_of_bill-drug")
    private Drug drug;
    @ManyToOne
    @JoinColumn(name = "bill_sale_id", nullable = false)
    @JsonBackReference(value = "drug_of_bill-bill_sale")
    private BillSale billSale;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "prescription_id", nullable = false)
    @JsonBackReference(value = "drug_of_bill-prescription_indicative")
    private Prescription prescription;
}
