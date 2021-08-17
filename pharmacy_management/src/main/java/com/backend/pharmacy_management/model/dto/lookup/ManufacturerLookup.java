package com.backend.pharmacy_management.model.dto.lookup;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ManufacturerLookup {
    private String manufacturerCode;
    private String manufacturerName;
    private String manufacturerAddress;
    private String manufacturerPhone;
    private String nmanufacturerNote;

    public ManufacturerLookup() {
    }

    public ManufacturerLookup(String manufacturerCode, String manufacturerName, String manufacturerAddress, String manufacturerPhone, String nmanufacturerNote) {
        this.manufacturerCode = manufacturerCode;
        this.manufacturerName = manufacturerName;
        this.manufacturerAddress = manufacturerAddress;
        this.manufacturerPhone = manufacturerPhone;
        this.nmanufacturerNote = nmanufacturerNote;
    }

}
