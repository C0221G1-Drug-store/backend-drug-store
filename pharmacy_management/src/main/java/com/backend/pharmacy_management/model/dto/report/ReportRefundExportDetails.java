package com.backend.pharmacy_management.model.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReportRefundExportDetails {
    private String maHoaDOn;
    private String ngayXuat;
    private String lyDo;
    private String soLuong;
    private String tongTien;
}
