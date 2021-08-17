package com.backend.pharmacy_management.model.entity.drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drug_image_detail")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "drugImageDetailId")
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

    public DrugImageDetail() {
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

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
