package com.backend.pharmacy_management.model.entity.bill_sale;

import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
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
    private double totalMoney;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;
    @OneToMany(mappedBy = "billSale")
    private Set<DrugOfBill> drugOfBillSet;
}
