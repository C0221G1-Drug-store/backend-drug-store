package com.backend.pharmacy_management.model.entity.drug;

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
    private Drug drug;
}
