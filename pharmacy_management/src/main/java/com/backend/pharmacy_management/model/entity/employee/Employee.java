package com.backend.pharmacy_management.model.entity.employee;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    private String employeeAddress;
    private String employeeImage;
    private String employeePhone;
    private String employeeStartDate;
    private String employeeNote;
    private int position;
    private String accountName;
    @OneToMany(mappedBy = "employee")
    List<ImportBill> importBills;
    @OneToMany(mappedBy = "employee")
    List<ExportBill> exportBills;
    @OneToMany(mappedBy = "employee")
    List<BillSale> billWholesales;
}
