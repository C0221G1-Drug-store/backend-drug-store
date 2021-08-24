package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.drug.Drug;
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
    private Long  indicativeId;
    private  Long totalPill;
    private  Long drinkDay;
    private  Long drinkTime;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;
}
