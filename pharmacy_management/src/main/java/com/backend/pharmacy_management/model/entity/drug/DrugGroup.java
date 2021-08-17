package com.backend.pharmacy_management.model.entity.drug;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="drug_group")
public class DrugGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long drugGroupId;
    private String drugGroupCode;
    private String drugGroupName;
    private boolean flag = true;
    @OneToMany(mappedBy = "drugGroup", fetch=FetchType.LAZY)
    @JsonManagedReference(value = "drug_group-drug")
    private Set<Drug> drugs;

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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Set<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(Set<Drug> drugs) {
        this.drugs = drugs;
    }
}
