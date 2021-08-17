package com.backend.pharmacy_management.model.dto.lookup;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerLookup {
    private String customerCode;
    private String customerName;
    private String customerAge;
    private String address;
    private String phone;
    private String group;
    private String note;

    public CustomerLookup() {
    }

    public CustomerLookup(String customerCode, String customerName, String customerAge, String address, String phone, String group, String note) {
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.address = address;
        this.phone = phone;
        this.group = group;
        this.note = note;
    }
}
