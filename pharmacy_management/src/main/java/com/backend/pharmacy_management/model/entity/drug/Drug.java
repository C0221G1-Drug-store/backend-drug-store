package com.backend.pharmacy_management.model.entity.drug;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Long drugId;
    private Long drugCode;
    private String drugName;
    private String activeElement;
    private String unit;
    private String conversionUnit;
    private Integer conversionRate;
    private Double wholesaleProfitRate;
    private Double retailProfitRate;
    @Column(columnDefinition = "TEXT")
    private String drugFaculty;
    private String manufacturer;
    private String origin;
    private String note;
    @Column(columnDefinition = "TEXT")
    private String drugSideEffect;
    private Boolean flag = true;

    @ManyToOne
    @JoinColumn(name = "drug_group_id")
    private DrugGroup drugGroup;
    @OneToMany(targetEntity = DrugImageDetail.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "drug_id", referencedColumnName = "drug_id")
    private List<DrugImageDetail> drugImageDetails;

    public Drug() {
        //contructor
    }

    public List<DrugImageDetail> getDrugImageDetails() {
        return drugImageDetails;
    }

    public void setDrugImageDetails(List<DrugImageDetail> drugImageDetails) {
        this.drugImageDetails = drugImageDetails;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Long getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(Long drugCode) {
        this.drugCode = drugCode;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getActiveElement() {
        return activeElement;
    }

    public void setActiveElement(String activeElement) {
        this.activeElement = activeElement;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getConversionUnit() {
        return conversionUnit;
    }

    public void setConversionUnit(String conversionUnit) {
        this.conversionUnit = conversionUnit;
    }

    public Integer getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(Integer conversionRate) {
        this.conversionRate = conversionRate;
    }

    public Double getWholesaleProfitRate() {
        return wholesaleProfitRate;
    }

    public void setWholesaleProfitRate(Double wholesaleProfitRate) {
        this.wholesaleProfitRate = wholesaleProfitRate;
    }

    public Double getRetailProfitRate() {
        return retailProfitRate;
    }

    public void setRetailProfitRate(Double retailProfitRate) {
        this.retailProfitRate = retailProfitRate;
    }

    public String getDrugFaculty() {
        return drugFaculty;
    }

    public void setDrugFaculty(String drugFaculty) {
        this.drugFaculty = drugFaculty;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDrugSideEffect() {
        return drugSideEffect;
    }

    public void setDrugSideEffect(String drugSideEffect) {
        this.drugSideEffect = drugSideEffect;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public DrugGroup getDrugGroup() {
        return drugGroup;
    }

    public void setDrugGroup(DrugGroup drugGroup) {
        this.drugGroup = drugGroup;
    }

}
