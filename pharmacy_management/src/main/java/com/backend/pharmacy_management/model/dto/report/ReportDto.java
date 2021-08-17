package com.backend.pharmacy_management.model.dto.report;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportDto {
    private String maHoaDon;
    private String tenNhaCungCap;
    private String ngayNhap;
    private Double tongTien;
    private String ghiChu;

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public void setTenNhaCungCap(String tenNhaCungCap) {
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getTenNhaCungCap() {
        return tenNhaCungCap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }
}
