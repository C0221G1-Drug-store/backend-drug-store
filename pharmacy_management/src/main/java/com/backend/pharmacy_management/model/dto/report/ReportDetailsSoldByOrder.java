package com.backend.pharmacy_management.model.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReportDetailsSoldByOrder {
    private String maHoaDon;
    private String ngayBan;
    private String tongTien;
    private String tenKhachHang;
}
