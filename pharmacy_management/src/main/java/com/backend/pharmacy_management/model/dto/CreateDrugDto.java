package com.backend.pharmacy_management.model.dto;
import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import java.util.List;

public class CreateDrugDto {
    private Long drugId;

    private String drugName;
    private String activeElement;
    private String unit;
    private String conversionUnit;
    private Integer conversionRate;
    private Double wholesaleProfitRate;
    private Double retailProfitRate;
    private List<DrugImageDetail> drugImageDetails;
    private String drugFaculty;
    private String manufacturer;
    private String origin;
    private String note;
    private DrugGroup drugGroup;
    private String drugSideEffect;

    public CreateDrugDto() {
//        contructor
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

    public DrugGroup getDrugGroup() {
        return drugGroup;
    }

    public void setDrugGroup(DrugGroup drugGroup) {
        this.drugGroup = drugGroup;
    }
}
