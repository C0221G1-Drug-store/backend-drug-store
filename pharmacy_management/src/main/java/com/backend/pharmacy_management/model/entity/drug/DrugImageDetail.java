package com.backend.pharmacy_management.model.entity.drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name="drug_image_detail")

public class DrugImageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_image_detail_id")
    private Long drugImageDetailId;
    @Column(name = "drug_image_detail_url", columnDefinition = "BLOB")
    private String drugImageDetailUrl;
//    private Boolean flag;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;



    public DrugImageDetail() {
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Long getDrugImageDetailId() {
        return drugImageDetailId;
    }

    public void setDrugImageDetailId(Long drugImageDetailId) {
        this.drugImageDetailId = drugImageDetailId;
    }

    public String getDrugImageDetailUrl() {
        return drugImageDetailUrl;
    }

    public void setDrugImageDetailUrl(String drugImageDetailUrl) {
        this.drugImageDetailUrl = drugImageDetailUrl;
    }
}
