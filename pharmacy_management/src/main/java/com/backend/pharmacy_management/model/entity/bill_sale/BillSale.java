package com.backend.pharmacy_management.model.entity.bill_sale;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "bill_sale")
public class BillSale {
    @Id
    @Column(name = "bill_sale_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private Set<DrugOfBill> drugOfBillSet;

    public BillSale() {
    }

    public BillSale(Long billSaleId, String billSaleCode, String invoiceDate, String billSaleNote, String billSaleType, Boolean flag, double totalMoney, Employee employee, Customer customer, Set<DrugOfBill> drugOfBillSet) {
        this.billSaleId = billSaleId;
        this.billSaleCode = billSaleCode;
        this.invoiceDate = invoiceDate;
        this.billSaleNote = billSaleNote;
        this.billSaleType = billSaleType;
        this.flag = flag;
        this.totalMoney = totalMoney;
        this.employee = employee;
        this.customer = customer;
        this.drugOfBillSet = drugOfBillSet;
    }

    public Long getBillSaleId() {
        return billSaleId;
    }

    public void setBillSaleId(Long billSaleId) {
        this.billSaleId = billSaleId;
    }
}
