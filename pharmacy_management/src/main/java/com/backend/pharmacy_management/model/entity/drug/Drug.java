package com.backend.pharmacy_management.model.entity.drug;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBillDrug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
//@NoArgsConstructor
@AllArgsConstructor
@Table(name="drug")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drug_id")
    private Long drugId;
    private String drugCode;
    private String drugName;
    private String activeElement;
    @Column(name = "drug_amout")
    private Long drugAmount;
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
//    @ManyToOne
//    @JoinColumn(name = "drug_group_id")
    @Column(name = "drug_group_id")
    private String drugGroup;
    @OneToMany(mappedBy = "drug")
    private List<DrugImageDetail> drugImageDetails;
    @OneToMany(mappedBy = "drug")
    private List<DrugOfBill> drugOfBills;
    @OneToMany(mappedBy = "drug")
    private List<Indicative> indicatives;
    @OneToMany(mappedBy = "drug")
    private List<ExportBillDetail> exportBillDetails;

    public Drug() {
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public String getDrugCode() {
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
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

    public Long getDrugAmount() {
        return drugAmount;
    }

    public void setDrugAmount(Long drugAmount) {
        this.drugAmount = drugAmount;
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

    public String getDrugGroup() {
        return drugGroup;
    }

    public void setDrugGroup(String drugGroup) {
        this.drugGroup = drugGroup;
    }

    public List<DrugImageDetail> getDrugImageDetails() {
        return drugImageDetails;
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
