package com.backend.pharmacy_management.model.entity.bill_sale;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
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
    private double totalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    @JsonBackReference(value="employee-bill_sale")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    @JsonBackReference(value="customer-bill_sale")
    private Customer customer;
    @OneToMany(mappedBy = "billSale")
    @JsonManagedReference(value="drug_of_bill-bill_sale")
    private List<DrugOfBill> drugOfBills;
}
