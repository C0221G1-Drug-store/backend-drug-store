package com.backend.pharmacy_management.model.entity.bill_sale;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bill_sale")
public class BillSale {
    @Id
    @Column(name = "bill_sale_id")
    private Long billSaleId;
    private String billSaleCode;
    @Column(columnDefinition = "datetime")
    private String invoiceDate;
    private String billSaleNote;
    private String billSaleType;
    private Boolean flag = true;
    private double totalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "billSale")
    @JsonBackReference(value="drug_of_bill-bill_sale")
    private List<DrugOfBill> drugOfBills;

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

    public List<DrugOfBill> getDrugOfBills() {
        return drugOfBills;
    }

    public void setDrugOfBills(List<DrugOfBill> drugOfBills) {
        this.drugOfBills = drugOfBills;
    }
}
