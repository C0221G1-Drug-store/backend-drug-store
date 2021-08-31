package com.backend.pharmacy_management.model.dto.report;

public class ReportDebt {
    private Double congNo;
    private String ngayNhap;

    public ReportDebt(Double congNo, String ngayNhap) {
        this.congNo = congNo;
        this.ngayNhap = ngayNhap;
    }

    public Double getCongNo() {
        return congNo;
    }

    public void setCongNo(Double congNo) {
        this.congNo = congNo;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }
}
