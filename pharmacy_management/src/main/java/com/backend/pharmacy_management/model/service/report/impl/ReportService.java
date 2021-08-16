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

    @Override
    public List<ReportImportDetails> reportImportDetails(String startDate, String endDate) {
        String sql = "select  import_system_code as ma_hoa_don, manufacturer_name as ten_nha_cung_cap, invoice_date as ngay_nhap , total_money as tong_tien, `status` as ghi_chu  from import_bill ib join manufacturer m on ib.manufacturer_id=m.manufacturer_id join payment p on p.payment_id = ib.payment_id where (import_system_code like 'HDNH%') and  (invoice_date between ? and ?)";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportImportDetails> list = new ArrayList<>();
        ReportImportDetails importDetail;
        for (Map<String, Object> row : rows) {
            String maHoaDon = (String) row.get("ma_hoa_don");
            String tenNhaCungCap = (String) row.get("ten_nha_cung_cap");
            String ngayNhap = row.get("ngay_nhap").toString();
            String tongTien = row.get("tong_tien").toString();
            String ghiChu = (String) row.get("ghi_chu");
            importDetail = new ReportImportDetails(maHoaDon, tenNhaCungCap, ngayNhap, tongTien, ghiChu);
            list.add(importDetail);
        }
        return list;
    }

    @Override
    public List<ReportCancellationDetails> reportCancellationDetails(String startDate, String endDate) {
        String sql = "select export_bill_code as ma_hoa_don, export_bill_date as ngay_xuat, export_bill_reason as ly_do, import_amount as so_luong, (import_price*import_amount) as tong_tien from export_bill eb join export_bill_type ebt on eb.export_bill_type_id = ebt.export_bill_type_id join manufacturer m on eb.manufacturer_id= m.manufacturer_id join import_bill ib on m.manufacturer_id= ib.manufacturer_id join import_bill_drug ibd on ib.import_bill_id = ibd.import_bill_id where (export_bill_code like 'HDXH%') and (export_bill_date between ? and ?);";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportCancellationDetails> list = new ArrayList<>();
        ReportCancellationDetails c;
        for (Map<String, Object> row : rows) {
            c = new ReportCancellationDetails(row.get("ma_hoa_don").toString(), row.get("ngay_xuat").toString(), row.get("ly_do").toString(), row.get("so_luong").toString(), row.get("tong_tien").toString());
            list.add(c);
        }
        return list;
    }

    @Override
    public List<ReportRefundExportDetails> reportRefundExportDetails(String startDate, String endDate) {
        String sql = "select export_bill_code as ma_hoa_don, export_bill_date as ngay_xuat, export_bill_reason as ly_do, import_amount as so_luong, (import_price*import_amount) as tong_tien from export_bill eb join export_bill_type ebt on eb.export_bill_type_id = ebt.export_bill_type_id join manufacturer m on eb.manufacturer_id= m.manufacturer_id join import_bill ib on m.manufacturer_id= ib.manufacturer_id join import_bill_drug ibd on ib.import_bill_id = ibd.import_bill_id where (export_bill_code like 'HDXT%') and (export_bill_date between ? and ?);";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportRefundExportDetails> list = new ArrayList<>();
        ReportRefundExportDetails r;
        for (Map<String, Object> row : rows) {
            r = new ReportRefundExportDetails(row.get("ma_hoa_don").toString(), row.get("ngay_xuat").toString(), row.get("ly_do").toString(), row.get("so_luong").toString(), row.get("tong_tien").toString());
            list.add(r);
        }
        return list;
    }

    @Override
    public List<ReportRetailDetails> reportRetailDetails(String startDate, String endDate) {
        String sql = "Select bill_sale_code as ma_hoa_don, invoice_date as ngay_ban, total_money as tong_tien FROM `bill_sale` WHERE (bill_sale_code like 'HDBL%') and  (invoice_date between ? and ?) and flag =1;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportRetailDetails> list = new ArrayList<>();
        ReportRetailDetails r;
        for (Map<String, Object> row : rows) {
            r = new ReportRetailDetails(row.get("ma_hoa_don").toString(), row.get("ngay_ban").toString(), row.get("tong_tien").toString());
            list.add(r);
        }
        return list;
    }

    @Override
    public List<ReportWholesaleDetails> reportWholesaleDetails(String startDate, String endDate) {
        String sql = "Select bill_sale_code as ma_hoa_don, invoice_date as ngay_ban, total_money as tong_tien,  customer_name as ten_khach_hang FROM `bill_sale` bs join customer c on bs.customer_id=c.customer_id WHERE (bill_sale_code like 'HDBS%') and  (invoice_date between ? and ?) and flag =1;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportWholesaleDetails> list = new ArrayList<>();
        ReportWholesaleDetails r;
        for (Map<String, Object> row : rows) {
            r = new ReportWholesaleDetails(row.get("ma_hoa_don").toString(), row.get("ngay_ban").toString(), row.get("tong_tien").toString(), row.get("ten_khach_hang").toString());
            list.add(r);
        }
        return list;
    }

    @Override
    public List<ReportDetailsSoldByOrder> reportDetailsSoldByOrder(String startDate, String endDate) {
        String sql = "Select bill_sale_code as ma_hoa_don,invoice_date as ngay_ban, total_money as tong_tien,customer_name as ten_khach_hang FROM `bill_sale` bs join customer c on bs.customer_id=c.customer_id WHERE (bill_sale_code like 'HDBD%') and  (invoice_date between ? and ?) and flag =1;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportDetailsSoldByOrder> list = new ArrayList<>();
        ReportDetailsSoldByOrder r;
        for (Map<String, Object> row : rows) {
            r = new ReportDetailsSoldByOrder(row.get("ma_hoa_don").toString(), row.get("ngay_ban").toString(), row.get("tong_tien").toString(), row.get("ten_khach_hang").toString());
            list.add(r);
        }
        return list;
    }

    @Override
    public List<SupplierList> supplierList() {
        String sql = "select manufacturer_name as ten_nha_cung_cap,manufacturer_address as  dia_chi, manufacturer_phone_number as so_dien_thoai, manufacturer_note as ghi_chu from manufacturer order by manufacturer_name;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<SupplierList> list = new ArrayList<>();
        SupplierList r;
        for (Map<String, Object> row : rows) {
            r = new SupplierList(row.get("ten_nha_cung_cap").toString(), row.get("dia_chi").toString(), row.get("so_dien_thoai").toString(), row.get("ghi_chu").toString());
            list.add(r);
        }
        return list;
    }


    @Override
    public List<ReportOnMedicationBeingProvided> reportOnMedicationBeingProvided() {
        String sql = "select drug_name as ten_thuoc, active_element as hoat_chat,drug_side_effect as tac_dung_phu,origin as nguon_goc, manufacturer as nha_cung_cap,note as ghi_chu from drug where flag =1 group by ten_thuoc";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<ReportOnMedicationBeingProvided> list = new ArrayList<>();
        ReportOnMedicationBeingProvided r;
        for (Map<String, Object> row : rows) {
            r = new ReportOnMedicationBeingProvided(row.get("ten_thuoc").toString(), row.get("hoat_chat").toString(), row.get("tac_dung_phu").toString(), row.get("nguon_goc").toString(), row.get("nha_cung_cap").toString(), row.get("ghi_chu").toString());
            list.add(r);
        }
        return list;
    }


}
