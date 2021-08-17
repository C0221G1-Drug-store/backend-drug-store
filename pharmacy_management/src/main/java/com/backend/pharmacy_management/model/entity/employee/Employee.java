package com.backend.pharmacy_management.model.entity.employee;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity

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
    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    List<ImportBill> importBills;
    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    List<ExportBill> exportBills;
    @JsonBackReference
    @OneToMany(mappedBy = "employee")
    List<BillSale> billWholesales;

    public Employee() {
    }

    public Employee(Long employeeId, String employeeCode, String employeeName, String employeeAddress, String employeeImage, String employeePhone, String employeeStartDate, String employeeNote, String position, String accountName) {
        this.employeeId = employeeId;
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeAddress = employeeAddress;
        this.employeeImage = employeeImage;
        this.employeePhone = employeePhone;
        this.employeeStartDate = employeeStartDate;
        this.employeeNote = employeeNote;
        this.position = position;
        this.accountName = accountName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeStartDate() {
        return employeeStartDate;
    }

    public void setEmployeeStartDate(String employeeStartDate) {
        this.employeeStartDate = employeeStartDate;
    }

    public String getEmployeeNote() {
        return employeeNote;
    }

    public void setEmployeeNote(String employeeNote) {
        this.employeeNote = employeeNote;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
