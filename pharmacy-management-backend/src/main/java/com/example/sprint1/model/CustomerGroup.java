package com.example.sprint1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;


import javax.persistence.*;
import java.util.List;

@Entity(name = "customer_groups")
public class CustomerGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerGroupId;
    private String customerGroupName;

    @OneToMany(mappedBy = "customerGroup")
    @JsonBackReference
    private List<Customer> customers;

    public CustomerGroup() {
    }

    public CustomerGroup(String customerGroupName, List<Customer> customers) {
        this.customerGroupName = customerGroupName;
        this.customers = customers;
    }

    public Long getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(Long customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public String getCustomerGroupName() {
        return customerGroupName;
    }

    public void setCustomerGroupName(String customerGroupName) {
        this.customerGroupName = customerGroupName;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
