package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Prescription;

public class DrugOfBillDto {
    private Long drugOfBillId;
    private Drug drug;
    private BillSale billSale;
    private int quantity;
    private Prescription prescription;

    public DrugOfBillDto() {
    }

    public Long getDrugOfBillId() {
        return drugOfBillId;
    }

    public void setDrugOfBillId(Long drugOfBillId) {
        this.drugOfBillId = drugOfBillId;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public BillSale getBillSale() {
        return billSale;
    }

    public void setBillSale(BillSale billSale) {
        this.billSale = billSale;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
