package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "indicative")
public class Indicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long indicativeId;
    private Long totalPill;
    private Long drinkDay;
    private Long drinkTime;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
    @ManyToOne
    @JoinColumn(name = "prescription_id ")
    private  Prescription prescription;

    @ManyToOne
    @JoinColumn(name = "bill_sale_id")
    @JsonBackReference
    private BillSale billSale;



}
