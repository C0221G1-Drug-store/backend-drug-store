package com.backend.pharmacy_management.model.dto.report;

public class ReportTurnover {
    private Double doanhThu;
    private String tuNgay;
    private String denNgay;

    public ReportTurnover(Double doanhThu, String tuNgay, String denNgay) {
        this.doanhThu = doanhThu;
        this.tuNgay = tuNgay;
        this.denNgay = denNgay;
    }

    public Double getDoanhThu() {
        return doanhThu;
    }

    public String getTuNgay() {
        return tuNgay;
    }

    public void setDoanhThu(Double doanhThu) {
        this.doanhThu = doanhThu;
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
