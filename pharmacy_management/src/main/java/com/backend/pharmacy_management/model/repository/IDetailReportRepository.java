package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.dto.DetailReportDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDetailReportRepository extends JpaRepository<DetailReportDto,Long> {
    @Query(value = "select  import_system_code as ma_hoa_don, manufacturer_name as ten_nha_cung_cap, invoice_date as ngay_nhap, total_money as tong_tien, `status` as ghi_chu fROM import_bill ib join manufacturer m on ib.manufacturer_id=m.manufacturer_id join payment p on p.payment_id = ib.payment_id WHERE (import_system_code like 'HDNH%') and  (invoice_date between ?1 and ?2)",nativeQuery = true)
    List<DetailReportDto> reportImportDetails(String startDate, String endDate);

}
