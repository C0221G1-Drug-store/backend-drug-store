package com.backend.pharmacy_management.model.dto.report;


public class ReportOnMedicationBeingProvided {
    private String tenThuoc;
    private String hoatChat;
    private String tacDungPhu;
    private String nguonGoc;
    private String nhaCungCap;
    private String ghiChu;

    public ReportOnMedicationBeingProvided(String tenThuoc, String hoatChat, String tacDungPhu, String nguonGoc, String nhaCungCap, String ghiChu) {
        this.tenThuoc = tenThuoc;
        this.hoatChat = hoatChat;
        this.tacDungPhu = tacDungPhu;
        this.nguonGoc = nguonGoc;
        this.nhaCungCap = nhaCungCap;
        this.ghiChu = ghiChu;
    }

    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }

    public void setHoatChat(String hoatChat) {
        this.hoatChat = hoatChat;
    }

    public void setTacDungPhu(String tacDungPhu) {
        this.tacDungPhu = tacDungPhu;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTenThuoc() {
        return tenThuoc;
    }

    public String getHoatChat() {
        return hoatChat;
    }

    public String getTacDungPhu() {
        return tacDungPhu;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public String getGhiChu() {
        return ghiChu;
    }
}
