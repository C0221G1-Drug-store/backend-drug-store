package com.backend.pharmacy_management.model.entity.drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity

@Table(name="drug_group")
public class DrugGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugGroupId;
    private String drugGroupCode;
    private String drugGroupName;
    @OneToMany(mappedBy = "drugGroup")
    @JsonBackReference
    private List<Drug> drugs;

    public DrugGroup() {
    }

    public Long getDrugGroupId() {
        return drugGroupId;
    }

    public void setDrugGroupId(Long drugGroupId) {
        this.drugGroupId = drugGroupId;
    }

    public String getDrugGroupCode() {
        return drugGroupCode;
    }

    public void setDrugGroupCode(String drugGroupCode) {
        this.drugGroupCode = drugGroupCode;
    }

    public String getDrugGroupName() {
        return drugGroupName;
    }

    public void setDrugGroupName(String drugGroupName) {
        this.drugGroupName = drugGroupName;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
