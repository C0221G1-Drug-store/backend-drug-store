package com.backend.pharmacy_management.model.entity.customer;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
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
    private String customerNote;
    private boolean flag = true;
    @ManyToOne
    @JoinColumn(name = "customer_group_id")
    @JsonManagedReference
    private CustomerGroup customers;

}