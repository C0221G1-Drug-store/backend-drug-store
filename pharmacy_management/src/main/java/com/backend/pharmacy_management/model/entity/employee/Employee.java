package com.backend.pharmacy_management.model.entity.employee;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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
    private String position;
    private String accountName;
    private boolean flag;
    @OneToMany(mappedBy = "employee")
//    @JsonBackReference
    List<ImportBill> importBills;
    @OneToMany(mappedBy = "employee")
//    @JsonBackReference
    List<ExportBill> exportBills;
    @OneToMany(mappedBy = "employee")
//    @JsonBackReference
    List<BillSale> billWholesales;
}
