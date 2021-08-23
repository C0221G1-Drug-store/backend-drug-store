package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.dto.ImportBillDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IImportBillRepository extends JpaRepository<ImportBill, Long> {
    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode," +
            "import_bill.accounting_voucher as accountingVoucher," +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id " +
            "order by invoiceDate desc limit ?1,5", nativeQuery = true)
    List<ImportBillDto> getImportBillDto(int index);

    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode," +
            "import_bill.accounting_voucher as accountingVoucher," +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id", nativeQuery = true)
    List<ImportBillDto> getImportBillDtoNotPaging();

    @Query(value = "{call selname2(:billCode, :startDate, :endDate, :col)}", nativeQuery = true)
    List<ImportBillDto> searchAndSort(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                      @Param("endDate") String endDate, @Param("col") String col);

    @Query(value = "select * from import_bill left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id left join payment on payment.payment_id = import_bill.payment_id order by import_bill.invoice_date desc", nativeQuery = true)
    Page<ImportBill> getPageImportBillDto(Pageable pageable);

    @Query(value = "{call selname2(:billCode, :startDate, :endDate, :col)}", nativeQuery = true)
    List<ImportBillDto> searchAndSortPaging(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                            @Param("endDate") String endDate, @Param("col") String col);

    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode," +
            "import_bill.accounting_voucher as accountingVoucher," +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id " +
            "order by invoiceDate desc", nativeQuery = true)
    List<ImportBillDto> getAllBill();

    @Transactional
    @Modifying
    @Query(value = "delete from import_bill where import_bill_id=?1", nativeQuery = true)
    void deleteImportBill(Long id);

    @Query(value = "{call selname3(:billCode, :startDate, :endDate, :col, :sort)}", nativeQuery = true)
    List<ImportBillDto> searchAndPaging(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                        @Param("endDate") String endDate, @Param("col") String col, @Param("sort") String sort);
}
