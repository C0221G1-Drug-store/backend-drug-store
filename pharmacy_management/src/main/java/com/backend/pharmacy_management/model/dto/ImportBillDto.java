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
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportBillDto {
    private Long importBillId;
    private String importSystemCode;
    private String accountingVoucher;
    private LocalDateTime invoiceDate;
    private Boolean flag;
    @JsonBackReference(value = "payment-import_bill")
    private  Payment payment;
    @JsonBackReference(value = "manufacturer-import_bill")
    private Manufacturer manufacturer;
    @JsonBackReference(value = "employee-import_bill")
    private Employee employee;
}
