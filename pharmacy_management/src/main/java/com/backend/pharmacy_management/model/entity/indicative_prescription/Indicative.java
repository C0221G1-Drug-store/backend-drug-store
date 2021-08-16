package com.backend.pharmacy_management.model.entity.indicative_prescription;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "indicative")
public class Indicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    private Long indicativeId;
    private Long totalPill;
    private Long drinkDay;
    private Long drinkTime;
//    @ManyToOne
//    @JoinColumn(name = "drug_id")
//    @JsonManagedReference
//    private Drug drug;
    private String drug;
    @JsonBackReference
    @OneToMany(mappedBy = "indicative")
    private List<Prescription> prescriptionList;

=======
    private Long  indicativeId;
    private  Long totalPill;
    private  Long drinkDay;
    private  Long drinkTime;
//    private  Long amountPill;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    @JsonManagedReference
    private Drug drug;
>>>>>>> origin
}
