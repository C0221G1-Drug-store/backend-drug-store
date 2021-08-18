package com.backend.pharmacy_management.model.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReportCancellationDetails {
    private String maHoaDon;
    private String ngayXuat;
    private String lyDo;
    private String soLuong;
    private String tongTien;
}
