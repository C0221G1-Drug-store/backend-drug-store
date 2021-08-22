package com.backend.pharmacy_management.model.dto.report;



public class ReportMedicinesNeedToBeImported {
    private String maThuoc;
    private String tenThuoc;

    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }
    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public String getMaThuoc() {
        return maThuoc;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }
}
