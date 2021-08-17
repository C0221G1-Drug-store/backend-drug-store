package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExportBillRepository extends JpaRepository<ExportBill, Long> {
    @Query(value = "IF( cast(?1 as date) = cast(?2 as date)) then select * from test where cast(test.date_create as time) > cast(?1 as time) and cast(test.date_create as time) < cast(?2 as time);" +
            "elseif( cast(?3 as time) = cast(?4 as time)) then select * from test where cast(test.date_create as date) > cast(?3 as date) and cast(test.date_create as date) < cast(?4 as date);" +
            "    else select * from test where cast(test.date_create as time) > cast(?3 as time) and cast(test.date_create as time) < cast(?4 as time) and cast(test.date_create as date) > cast(?1 as date) and cast(test.date_create as date) < cast(field2 as date);" +
            "    end if;", nativeQuery = true)
    Page<ExportBill> findByTimeFields(String field1, String field2 , String field3 , String field4 , long field5, Pageable pageable);
}
