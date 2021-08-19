package com.backend.pharmacy_management.model.entity.customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private CustomerGroup customers;
}