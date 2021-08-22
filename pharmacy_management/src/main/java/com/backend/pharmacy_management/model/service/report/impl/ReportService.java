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
            importDetail = new ReportImportDetails(maHoaDon, tenNhaCungCap, formatDate(ngayNhap), tongTien, ghiChu);
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
            c = new ReportCancellationDetails(row.get("ma_hoa_don").toString(), formatDate(row.get("ngay_xuat").toString()), row.get("ly_do").toString(), row.get("so_luong").toString(), row.get("tong_tien").toString());
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
            r = new ReportRefundExportDetails(row.get("ma_hoa_don").toString(), formatDate(row.get("ngay_xuat").toString()), row.get("ly_do").toString(), row.get("so_luong").toString(), row.get("tong_tien").toString());
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
            r = new ReportRetailDetails(row.get("ma_hoa_don").toString(), formatDate(row.get("ngay_ban").toString()), row.get("tong_tien").toString());
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
            r = new ReportWholesaleDetails(row.get("ma_hoa_don").toString(), formatDate(row.get("ngay_ban").toString()), row.get("tong_tien").toString(), row.get("ten_khach_hang").toString());
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
            r = new ReportDetailsSoldByOrder(row.get("ma_hoa_don").toString(), formatDate(row.get("ngay_ban").toString()), row.get("tong_tien").toString(), row.get("ten_khach_hang").toString());
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


    @Override
    public List<ReportSellingDiary> sellingDiarys(String startDate, String endDate) {
        String sql = "select e.employee_code as ma_nhan_vien,employee_name as ten_nhan_vien,bill_sale_code as ma_hoa_don,invoice_date as ngay_ban,total_money as tong_tien from employee e join bill_sale bs on e.employee_id = bs.employee_id where invoice_date between ? and ? order by employee_name, e.employee_id;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        List<ReportSellingDiary> sellingDiarys = new ArrayList<>();
        ReportSellingDiary sellingDiary;
        for (Map<String, Object> row : rows) {
            sellingDiary = new ReportSellingDiary();
            sellingDiary.setMaNhanVien((String) row.get("ma_nhan_vien"));
            sellingDiary.setTenNhanVien((String) row.get("ten_nhan_vien"));
            sellingDiary.setMaHoaDon((String) row.get("ma_hoa_don"));
            sellingDiary.setNgayBan(formatDate(row.get("ngay_ban").toString()));
            sellingDiary.setTongTien((Double) row.get("tong_tien"));
            sellingDiarys.add(sellingDiary);
        }
        return sellingDiarys;
    }

    @Override
    public List<ReportMedicinesNeedToBeImported> medicinesNeedToBeImporteds() {
        String sql = "select drug_code as ma_thuoc, drug_name as ten_thuoc from drug where drug_amout<5 group by drug_code;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
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
    public List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires() {
        String sql = "select d.drug_code as ma_thuoc, drug_name as ten_thuoc,expiry as ngay_het_han from drug d join import_bill_drug ibd on d.drug_id = ibd.drug_id where datediff(now(),expiry) <= 10;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        List<ReportTheDrugIsAboutToExpire> theDrugIsAboutToExpires = new ArrayList<>();
        ReportTheDrugIsAboutToExpire theDrugIsAboutToExpire;
        for (Map<String, Object> row : rows) {
            theDrugIsAboutToExpire = new ReportTheDrugIsAboutToExpire();
            theDrugIsAboutToExpire.setMaThuoc((String) row.get("ma_thuoc"));
            theDrugIsAboutToExpire.setTenThuoc((String) row.get("ten_thuoc"));
            theDrugIsAboutToExpire.setNgayHetHan(formatDate(row.get("ngay_het_han").toString()));
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
            bestSellingDrug = new ReportBestSellingDrug(row.get("ma_thuoc").toString(), row.get("nhom_thuoc").toString(), row.get("ten_thuoc").toString(), row.get("so_luong_ban").toString());
            list1.add(bestSellingDrug);
        }
        int check = 5;
        if (list1.size() > check) {
            Double c = Double.valueOf(list1.get(check - 1).getSoLuongBan());
            for (int i = 0; i < list1.size(); i++) {
                if (Double.valueOf(list1.get(check - 1).getSoLuongBan()) >= c) {
                    list2.add(list1.get(i));
                }
            }
            return list2;
        }
        return list1;
    }

    @Override
    public List<ReportDebt> reportDebt(String startDate, String endDate) {
        String a = "select sum(manufacturer_debts) as tong_no , invoice_date as ngay_nhap from manufacturer m join import_bill ib on m.manufacturer_id = ib.manufacturer_id where invoice_date between  ? and  ?  group by invoice_date;";
        String b = "select sum(prepayment) as tra_truoc, invoice_date as ngay_tra from payment p join import_bill ib on p.payment_id = ib.payment_id where invoice_date between ? and ? group by invoice_date;";
        List<Map<String, Object>> tongNo = jdbcTemplate.queryForList(a, startDate, endDate);
        List<Map<String, Object>> traTruoc = jdbcTemplate.queryForList(b, startDate, endDate);
        List<ReportDebt> r = new ArrayList<>();
        ReportDebt rd;
        for (Map<String, Object> n : tongNo) {
            for (Map<String, Object> t : traTruoc) {
                String ngayNhap = n.get("ngay_nhap").toString();
                String ngayTra = t.get("ngay_tra").toString();
                if (ngayTra.equals(ngayNhap)) {
                    Double congNo = (Double) n.get("tong_no") - (Double) t.get("tra_truoc");
                    rd = new ReportDebt(congNo, formatDate(n.get("ngay_nhap").toString()));
                    r.add(rd);
                }
            }
        }
        return r;
    }

    @Override
    public List<ReportTurnover> reportTurnover(String startDate, String endDate) {
        String a = "select sum(total_money) as tien_ban from bill_sale where bill_sale_code like 'HDBL%' or bill_sale_code like 'HDBS%' or bill_sale_code like 'HDBD%' and invoice_date between ? and ?;";
        String b = "select sum(total_money) as tien_tra from bill_sale where bill_sale_code like 'HDNT%' and invoice_date between ? and ?;";
        List<Map<String, Object>> tienBans = jdbcTemplate.queryForList(a, startDate, endDate);
        List<Map<String, Object>> tienTras = jdbcTemplate.queryForList(b, startDate, endDate);
        List<ReportTurnover> r = new ArrayList<>();
        if (tienBans.get(0).get("tien_ban") == null || tienTras.get(0).get("tien_tra") == null) {
            r.add(new ReportTurnover(null, startDate, endDate));
            return r;
        }
        Double tienBan = (Double) tienBans.get(0).get("tien_ban");
        Double tienTra = (Double) tienTras.get(0).get("tien_tra");
        r.add(new ReportTurnover(tienBan - tienTra, formatDate(startDate), formatDate(endDate)));
        return r;
    }

    @Override
    public List<ReportProfit> reportProfit(String startDate, String endDate) {
        String sql = "select sum(dob.quantity * ibd.import_price * d.retail_profit_rate *100) as loi_nhuan from drug d join import_bill_drug ibd on d.drug_id = ibd.drug_id join drug_of_bill dob on d.drug_id = dob.drug_id join bill_sale bs on dob.bill_sale_id = bs.bill_sale_id where bs.invoice_date between ? and ? group by invoice_date;";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, startDate, endDate);
        ReportProfit rp;
        List<ReportProfit> rList = new ArrayList<>();
        for (Map<String, Object> r : rows) {
            rp = new ReportProfit((Double) r.get("loi_nhuan"), formatDate(startDate), formatDate(endDate));
            rList.add(rp);
        }
        return rList;
    }

    @Override
    public List<StatisticalChart> getStatisticalChart(String startDate, String endDate) {
        String sqlProfit = "select sum(dob.quantity * ibd.import_price * d.retail_profit_rate *100) as profit, invoice_date as date_sale from drug d join import_bill_drug ibd on d.drug_id = ibd.drug_id join drug_of_bill dob on d.drug_id = dob.drug_id join bill_sale bs on dob.bill_sale_id = bs.bill_sale_id where bs.invoice_date between ? and ? group by invoice_date order by invoice_date;";
        String sqlSaleBill = "select sum(total_money) as sale_money, invoice_date as date_sale from bill_sale where (bill_sale_code like 'HDBL%' or bill_sale_code like 'HDBS%' or bill_sale_code like 'HDBD%') and (invoice_date between ? and ?) group by invoice_date order by invoice_date;";
        String sqlCancelBill = "select sum(total_money) as cancel_money, invoice_date as date_sale from bill_sale where (bill_sale_code like 'HDNT%') and (invoice_date between ? and ?) group by invoice_date order by invoice_date ;";
        List<Map<String, Object>> profitSql = jdbcTemplate.queryForList(sqlProfit, startDate, endDate);
        List<Map<String, Object>> saleBills = jdbcTemplate.queryForList(sqlSaleBill, startDate, endDate);
        List<Map<String, Object>> cancelBills = jdbcTemplate.queryForList(sqlCancelBill, startDate, endDate);
        List<StatisticalChart> statisticalCharts = new ArrayList<>();
        List<Turnover> turnovers = new ArrayList<>();
        List<Profit> profits = new ArrayList<>();
        for (Map<String, Object> s : saleBills) {
            for (Map<String, Object> c : cancelBills) {
                if (s.get("date_sale").toString().equals(c.get("date_sale").toString())) {
                    turnovers.add(new Turnover((Double) s.get("sale_money") - (Double) c.get("cancel_money"), s.get("date_sale").toString()));
                }
            }
        }
        for (Map<String, Object> p : profitSql) {
            profits.add(new Profit((Double) p.get("profit"), p.get("date_sale").toString()));
        }
        for (Turnover t : turnovers) {
            Double turnover = 0.0;
            Double profit = 0.0;
            for (Profit p : profits) {
                if (t.getDateSale().equals(p.getDateSale())) {
                    turnover += t.getTurnover();
                    profit += p.getProfit();
                }
            }
            statisticalCharts.add(new StatisticalChart(turnover, profit, t.getDateSale()));
        }
        return statisticalCharts;
    }

    private String formatDate(String date) {
        String[] a = date.split("-");
        String[] b = a[2].split("T");
        String swap;
        swap = a[0];
        a[0] = b[0];
        String z = a[0] + '-' + a[1] + '-' + swap;
        return z;
    }
}
