package com.backend.pharmacy_management.model.dto;
import lombok.Getter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

@Getter
public class DetailReportDto  {
    private String maHoaDon;
    private String tenNhaCungCap;
    private String ngayNhap;
    private Double tongTien;
    private String ghiChu;
    public DetailReportDto() {
    }

}
