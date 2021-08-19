package com.backend.pharmacy_management.model.entity.drug;

import javax.persistence.*;

@Entity
@Table(name = "drug_image_detail")
public class DrugImageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_image_detail_id")
    private Long drugImageDetailId;
    @Column(name = "drug_image_detail_url")
    private String drugImageDetailUrl;
    @ManyToOne
    @JoinColumn(name = "drug_id")
    private Drug drug;

    public DrugImageDetail() {
        //contructor
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
