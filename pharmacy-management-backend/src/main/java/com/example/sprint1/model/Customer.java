package com.example.sprint1.model;
import javax.persistence.*;

@Entity(name = "customers")
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
    private Boolean flag;

    @ManyToOne
    @JoinColumn(name = "customer_group_id" ,referencedColumnName = "customerGroupId")
    private CustomerGroup customerGroup;

    public Customer() {
    }

    public Customer(String customerCode, String customerName, Integer customerAge, String customerAddress, String customerPhone, String customerNote, Boolean flag, CustomerGroup customerGroup) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerNote = customerNote;
        this.flag = flag;
        this.customerGroup = customerGroup;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }
}