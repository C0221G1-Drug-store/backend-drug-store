package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.import_bill_payment.Payment;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportBillDto {
    private Long importBillId;
    @NotNull
    private String importSystemCode;
    @NotNull
    private String accountingVoucher;
    @NotNull
    private String invoiceDate;
    private Boolean flag;
    private  Payment payment;
    private Manufacturer manufacturer;
    private Employee employee;
}
