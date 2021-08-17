package com.backend.pharmacy_management.dto;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class ManufacturerDto {
    private Integer manufacturerId;
    @NotBlank(message = " Not Null")
    private String manufacturerCode;
    @NotBlank(message = " Not Null")
    private String manufacturerName;
    @NotBlank(message = " Not Null")
    private String manufacturerAddress;
    @NotBlank(message = " Not Null")
    @Email(message = "Enter the correct format")
    private String manufacturerEmail;
    @NotBlank(message = " Not Null")
    private String manufacturerPhoneNumber;
    private double manufacturerDebts;
    @NotBlank(message = " Not Null")
    private String manufacturerNote ;


    public ManufacturerDto(Integer manufacturerId, @NotBlank(message = " Not Null") String manufacturerCode, @NotBlank(message = " Not Null") String manufacturerName, @NotBlank(message = " Not Null") String manufacturerAddress, @NotBlank(message = " Not Null") @Email(message = "Enter the correct format") String manufacturerEmail, @NotBlank(message = " Not Null") String manufacturerPhoneNumber, double manufacturerDebts, @NotBlank(message = " Not Null") String manufacturerNote) {
        this.manufacturerId = manufacturerId;
        this.manufacturerCode = manufacturerCode;
        this.manufacturerName = manufacturerName;
        this.manufacturerAddress = manufacturerAddress;
        this.manufacturerEmail = manufacturerEmail;
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
        this.manufacturerDebts = manufacturerDebts;
        this.manufacturerNote = manufacturerNote;
    }

    public ManufacturerDto() {
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getManufacturerCode() {
        return manufacturerCode;
    }

    public void setManufacturerCode(String manufacturerCode) {
        this.manufacturerCode = manufacturerCode;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getManufacturerAddress() {
        return manufacturerAddress;
    }

    public void setManufacturerAddress(String manufacturerAddress) {
        this.manufacturerAddress = manufacturerAddress;
    }

    public String getManufacturerEmail() {
        return manufacturerEmail;
    }

    public void setManufacturerEmail(String manufacturerEmail) {
        this.manufacturerEmail = manufacturerEmail;
    }

    public String getManufacturerPhoneNumber() {
        return manufacturerPhoneNumber;
    }

    public void setManufacturerPhoneNumber(String manufacturerPhoneNumber) {
        this.manufacturerPhoneNumber = manufacturerPhoneNumber;
    }

    public double getManufacturerDebts() {
        return manufacturerDebts;
    }

    public void setManufacturerDebts(double manufacturerDebts) {
        this.manufacturerDebts = manufacturerDebts;
    }

    public String getManufacturerNote() {
        return manufacturerNote;
    }

    public void setManufacturerNote(String manufacturerNote) {
        this.manufacturerNote = manufacturerNote;
    }

  
}
