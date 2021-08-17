package com.backend.pharmacy_management.model.entity.customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerCode;
    private String customerName;
    private Integer customerAge;
    private String customerAddress;
    private String customerPhone;
    private boolean flag = true;
    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    @JsonManagedReference
    private CustomerGroup customers;
}