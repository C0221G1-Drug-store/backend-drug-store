package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
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
//    private  Long amountPill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
}
