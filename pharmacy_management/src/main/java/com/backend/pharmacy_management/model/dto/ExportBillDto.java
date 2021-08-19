package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillType;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ExportBillDto implements Validator {
    private Long exportBillId;
    @NotBlank
    private String exportBillCode;
    @NotBlank
    private String exportBillDate;
    @NotBlank
    private String exportBillReason;
    private String exportBillAddress;
    private boolean flag=true;
    private ExportBillType exportBillType;

    private Employee employee;

    private Manufacturer manufacturer;


    public ExportBillDto() {
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
