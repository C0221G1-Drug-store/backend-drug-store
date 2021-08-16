package com.backend.pharmacy_management.model.service.report.impl;

import com.backend.pharmacy_management.model.dto.report.ReportDto;
import com.backend.pharmacy_management.model.service.report.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ReportService implements IReportService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean checkDateTime() {
        return false;
    }

    @Override
    public List<ReportDto> importDetails(String startDate, String endDate) {
        String sql = "select  import_system_code as ma_hoa_don, manufacturer_name as ten_nha_cung_cap, invoice_date as ngay_nhap , total_money as tong_tien, `status` as ghi_chu  from import_bill ib join manufacturer m on ib.manufacturer_id=m.manufacturer_id join payment p on p.payment_id = ib.payment_id where (import_system_code like 'HDNH%') and  (invoice_date between ? and ?)";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportDto> reportDtos = new ArrayList<>();
        ReportDto reportDto;
        for (Map<String, Object> row : rows) {
            reportDto = new ReportDto();
            reportDto.setMaHoaDon((String) row.get("ma_hoa_don"));
            reportDto.setTenNhaCungCap((String) row.get("ten_nha_cung_cap"));
            reportDto.setNgayNhap(row.get("ngay_nhap").toString());
            reportDto.setTongTien((Double) row.get("tong_tien"));
            reportDto.setGhiChu((String) row.get("ghi_chu"));
            reportDtos.add(reportDto);
        }
        return reportDtos;
    }

    @Override
    public List<ReportDto> cancellationDetails(String startDate, String endDate) {
        return null;
    }

}
