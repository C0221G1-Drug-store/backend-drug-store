package com.backend.pharmacy_management.model.service.report.impl;

import com.backend.pharmacy_management.model.dto.report.*;
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

    @Override
    public List<ReportSellingDiary> sellingDiarys(String startDate, String endDate) {
        String sql = "select employee_code as ma_nhan_vien,employee_name as ten_nhan_vien,bill_sale_code as ma_hoa_don,invoice_date as ngay_ban,total_money as tong_tien from employee e join bill_sale bs on e.employee_id = bs.employee_id where invoice_date between ? and ? order by employee_name, employee_id;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportSellingDiary> sellingDiarys = new ArrayList<>();
        ReportSellingDiary sellingDiary;
        for (Map<String, Object> row : rows) {
            sellingDiary = new ReportSellingDiary();
            sellingDiary.setMaNhanVien((String) row.get("ma_nhan_vien"));
            sellingDiary.setTenNhanVien((String) row.get("ten_nhan_vien"));
            sellingDiary.setMaHoaDon((String) row.get("ma_hoa_don"));
            sellingDiary.setNgayBan(row.get("ngay_ban").toString());
            sellingDiary.setTongTien((Double) row.get("tong_tien"));
            sellingDiarys.add(sellingDiary);
        }
        return sellingDiarys;
    }

    @Override
    public List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds(String startDate, String endDate) {
        String sql = "select d.drug_code as ma_thuoc, drug_name as ten_thuoc from drug d join import_bill_drug ibd on d.drug_id = ibd.drug_id where import_amount<5;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds = new ArrayList<>();
        ReportMedicinesNeedToBeImported medicinesNeedToBeImported;
        for (Map<String, Object> row : rows) {
            medicinesNeedToBeImported = new ReportMedicinesNeedToBeImported();
            medicinesNeedToBeImported.setMaThuoc((String) row.get("ma_thuoc"));
            medicinesNeedToBeImported.setTenThuoc((String) row.get("ten_thuoc"));
            medicinesNeedToBeImporteds.add(medicinesNeedToBeImported);
        }
        return medicinesNeedToBeImporteds;
    }

    @Override
    public List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires(String startDate, String endDate) {
        String sql = "select d.drug_code as ma_thuoc, drug_name as ten_thuoc,expiry as ngay_het_han from drug d join import_bill_drug ibd on d.drug_id = ibd.drug_id where datediff(now(),expiry) <= 10;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires = new ArrayList<>();
        ReportTheDrugIsAboutToExpire theDrugIsAboutToExpire;
        for (Map<String, Object> row : rows) {
            theDrugIsAboutToExpire = new ReportTheDrugIsAboutToExpire();
            theDrugIsAboutToExpire.setMaThuoc((String) row.get("ma_thuoc"));
            theDrugIsAboutToExpire.setTenThuoc((String) row.get("ten_thuoc"));
            theDrugIsAboutToExpire.setNgayHetHan(row.get("ngay_het_han").toString());
            theDrugIsAboutToExpires.add(theDrugIsAboutToExpire);
        }
        return theDrugIsAboutToExpires;
    }

    @Override
    public List<ReportBestSellingDrug> bestSellingDrugs(String startDate, String endDate) {
        String sql = "select d.drug_code as ma_thuoc,drug_group_name as nhom_thuoc,drug_name as ten_thuoc,sum(quantity) as so_luong_ban from drug d join drug_of_bill dob on d.drug_id=dob.drug_id join drug_group dg on d.drug_group_id = dg.drug_group_id join bill_sale bs on dob.bill_sale_id= bs.bill_sale_id where invoice_date between ? and ? group by drug_code order by sum(quantity) desc;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportBestSellingDrug> list1 = new ArrayList<>();
        List<ReportBestSellingDrug> list2 = new ArrayList<>();
        ReportBestSellingDrug bestSellingDrug;
        for (Map<String, Object> row : rows) {
            bestSellingDrug = new ReportBestSellingDrug(row.get("ma_thuoc").toString(),row.get("nhom_thuoc").toString(),row.get("ten_thuoc").toString(),(Double)row.get("so_luong_ban"));
            list1.add(bestSellingDrug);
        }
        Double check= list1.get(100).getSoLuongBan();
        for (int i = 0; i < list1.size() ; i++) {
            if(list1.get(i).getSoLuongBan() >= check){
                list2.add(list1.get(i));
            } else {
                break;
            }
        }
        return list2;
    }

}
