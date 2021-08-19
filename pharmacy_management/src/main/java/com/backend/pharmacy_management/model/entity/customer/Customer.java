package com.backend.pharmacy_management.model.entity.customer;
import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String customerCode;
    private String name;
    private int age;
    private String address;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    @JsonBackReference(value = "customer-customer_group")
    private CustomerGroup customers;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference(value = "customer-bill_sale")
    List<BillSale> billWholesales;
}