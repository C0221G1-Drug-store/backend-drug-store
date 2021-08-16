package com.backend.pharmacy_management.model.entity.drug;

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
@Table(name="drug_image_detail")

public class DrugImageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_image_detail_id")
    private Long drugImageDetailId;
    @Column(name = "drug_image_detail_url", columnDefinition = "BLOB")
    private String drugImageDetailUrl;
    private Boolean flag;
    @ManyToOne
    @JoinColumn(name = "drug_id", referencedColumnName = "drug_id")
//    @JsonManagedReference
    private Drug drug;
}
