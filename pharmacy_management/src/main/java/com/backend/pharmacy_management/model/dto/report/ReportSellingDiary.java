package com.backend.pharmacy_management.model.dto.report;



public class ReportSellingDiary {
    private String maNhanVien;
    private String tenNhanVien;
    private String maHoaDon;
    private String ngayBan;
    private Double tongTien;




    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }



    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }


    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }



    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }


    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public Double getTongTien() {
        return tongTien;
    }
}

