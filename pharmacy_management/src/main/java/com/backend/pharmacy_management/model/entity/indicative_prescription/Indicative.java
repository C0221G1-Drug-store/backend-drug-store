package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "indicative")
public class Indicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  indicativeId;
    private  Long totalPill;
    private  Long drinkDay;
    private  Long drinkTime;
    private  Long amountPill;
    @ManyToOne
    @JoinColumn(name = "drug_id")

    private Drug drug;
}
