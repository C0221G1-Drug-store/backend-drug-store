package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonBackReference(value = "indicatives_drug-drug")
    private Drug drug;

}
