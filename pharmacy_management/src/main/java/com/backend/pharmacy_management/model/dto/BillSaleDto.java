package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillSaleDto {
    private Long billSaleId;
    private String billSaleCode;
    private String invoiceDate;
    private String billSaleNote;
    private String billSaleType;
    private Boolean flag = true;
    private double totalMoney;
    private Employee employee;
    private Customer customer;


}
