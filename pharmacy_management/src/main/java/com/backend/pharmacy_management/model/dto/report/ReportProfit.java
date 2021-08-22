package com.backend.pharmacy_management.model.dto.report;

public class ReportProfit {
    private Double loiNhuan;
    private String tuNgay;
    private String denNgay;
    public ReportProfit(Double loiNhuan, String tuNgay, String denNgay) {
        this.loiNhuan = loiNhuan;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
    }

    public Double getLoiNhuan() {
        return loiNhuan;
    }

    public String getTuNgay() {
        return tuNgay;
    }

    public void setLoiNhuan(Double loiNhuan) {
        this.loiNhuan = loiNhuan;
    }

    public void setTuNgay(String tuNgay) {
        this.tuNgay = tuNgay;
    }

    public void setDenNgay(String denNgay) {
        this.denNgay = denNgay;
    }

    public String getDenNgay() {
        return denNgay;
    }
}
