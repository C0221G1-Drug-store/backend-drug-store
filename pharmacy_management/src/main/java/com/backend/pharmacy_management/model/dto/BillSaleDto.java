package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;

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

    public BillSaleDto() {
    }

    public Long getBillSaleId() {
        return billSaleId;
    }

    public void setBillSaleId(Long billSaleId) {
        this.billSaleId = billSaleId;
    }

    public String getBillSaleCode() {
        return billSaleCode;
    }

    public void setBillSaleCode(String billSaleCode) {
        this.billSaleCode = billSaleCode;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getBillSaleNote() {
        return billSaleNote;
    }

    public void setBillSaleNote(String billSaleNote) {
        this.billSaleNote = billSaleNote;
    }

    public String getBillSaleType() {
        return billSaleType;
    }

    public void setBillSaleType(String billSaleType) {
        this.billSaleType = billSaleType;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
