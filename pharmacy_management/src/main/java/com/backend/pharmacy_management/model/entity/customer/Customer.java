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
    private Long customerId;
    private String customerCode;
    private String customerName;
    private Integer customerAge;
    private String customerAddress;
    private String customerPhone;
    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    private CustomerGroup customers;
}