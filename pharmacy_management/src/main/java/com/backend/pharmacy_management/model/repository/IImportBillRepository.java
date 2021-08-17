package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImportBillRepository extends JpaRepository<ImportBill, Long> {
//    @Query(value = "select *" +
//            " from import_bill " +
//            "limit ?1,5;", nativeQuery = true)
//    List<ImportBill>getAllImportBill(int index);

    @Query(value = "select * from import_bill order by invoice_date desc limit ?1,5;", nativeQuery = true)
    List<ImportBill> getAllImportBill(int index);

    @Query(value = "select *" +
            " from import_bill ", nativeQuery = true)
    List<ImportBill> getAllImportBillNotPaging();

    @Query(value = "select * from import_bill where import_system_code like :importCode", nativeQuery = true)
    List<ImportBill> search(@Param("importCode") String importCode);

    @Query(value = "select * from import_bill where (import_system_code like :importCode) and (invoice_date between :startDate  and :endDate) order by :sort desc ", nativeQuery = true)
    List<ImportBill> searchBill(@Param("importCode") String importCode, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("sort") String sort);

    @Query(value = "select * from import_bill order by invoice_date desc", nativeQuery = true)
    Page<ImportBill> getAllBill(Pageable pageable);

    @Procedure(name = "selname")
    List<ImportBill> searchSort(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                @Param("endDate") String endDate, @Param("col") String col);


}
