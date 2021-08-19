package com.backend.pharmacy_management.model.dto.bill_sale;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;

import javax.persistence.Column;

public class BillSaleDto {
     Long billSaleId;
     String billSaleCode;
     String invoiceDate;
     String billSaleNote;
     String billSaleType;
     Boolean flag = true;
     double totalMoney;
     Employee employee;
     Customer customer;

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
