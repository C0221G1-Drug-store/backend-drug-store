package com.backend.pharmacy_management.model.entity.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer_group")
public class CustomerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerGroupId;
    private String customerGroupName;
    @OneToMany(mappedBy = "customers")
    @JsonBackReference
    private List<Customer> customers;
}