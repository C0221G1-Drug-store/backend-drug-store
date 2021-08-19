package com.backend.pharmacy_management.model.entity.drug;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name="drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Long drugId;
    @Column(name = "drug_code")
    private Long drugCode;
    @Column(name = "drug_name")
    private String drugName;
    @Column(name = "active_element")
    private String activeElement;
    @Column(name = "drug_amount")
    private Long drugAmount;
    @Column(name = "unit")
    private String unit;
    @Column(name = "conversion_unit")
    private String conversionUnit;
    @Column(name = "conversion_rate")
    private Integer conversionRate;
    @Column(name = "wholesale_profit_rate")
    private Double wholesaleProfitRate;
    @Column(name = "retail_profit_rate")
    private Double retailProfitRate;
    @Column(name = "drug_faculty", columnDefinition = "TEXT")
    private String drugFaculty;
    @Column(name = "drug_side_effect", columnDefinition = "TEXT")
    private String drugSideEffect;
    private Boolean flag = true;
    private String manufacturer;
    private String origin;
    private String note;
    @Column(columnDefinition = "TEXT")
    private String drugSideEffect;
    private Boolean flag = true;
    @OneToMany(mappedBy = "drug")
    @JsonManagedReference(value = "drug_image_detail_drug")
    private List<DrugImageDetail> drugImageDetails;
    @OneToMany(mappedBy = "drug")
    @JsonManagedReference(value = "drug_of_bill_drug")
    private List<DrugOfBill> drugOfBills;
    @OneToMany(mappedBy = "drug")
    @JsonManagedReference(value = "indicatives_drug_drug")
    private List<Indicative> indicatives;
    @OneToMany(mappedBy = "drug")
    @JsonManagedReference(value = "export_bill_detail_drug")
    private List<ExportBillDetail> exportBillDetails;
    @OneToMany(mappedBy = "drug")
    @JsonManagedReference(value = "import_bill_drug-drug")
    private List<ImportBillDrug> importBillDrugs;
    @ManyToOne
    @JoinColumn(name = "drug_group_id")
    private DrugGroup drugGroup;
    @OneToMany(targetEntity = DrugImageDetail.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "drug_id",referencedColumnName = "drug_id")
    private List<DrugImageDetail> drugImageDetails;

    public Drug() {
    }

    public List<DrugImageDetail> getDrugImageDetails() {
        return drugImageDetails;
    }

    public void setDrugImageDetails(List<DrugImageDetail> drugImageDetails) {
        this.drugImageDetails = drugImageDetails;
    }

    public Long getDrugAmount() {
        return drugAmount;
    }

    public void setDrugAmount(Long drugAmount) {
        this.drugAmount = drugAmount;
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

    public void setDrugImageDetails(List<DrugImageDetail> drugImageDetails) {
        this.drugImageDetails = drugImageDetails;
    }

    public List<DrugOfBill> getDrugOfBills() {
        return drugOfBills;
    }

    public void setDrugOfBills(List<DrugOfBill> drugOfBills) {
        this.drugOfBills = drugOfBills;
    }

    public List<Indicative> getIndicatives() {
        return indicatives;
    }

    public void setIndicatives(List<Indicative> indicatives) {
        this.indicatives = indicatives;
    }

    public List<ExportBillDetail> getExportBillDetails() {
        return exportBillDetails;
    }

    public void setExportBillDetails(List<ExportBillDetail> exportBillDetails) {
        this.exportBillDetails = exportBillDetails;
    }

}
