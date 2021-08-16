package com.backend.pharmacy_management.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDto {
    private Long employeeId;
    private String employeeCode;
    @NotBlank(message = "Trường này không được để trống. (*)")
    private String employeeName;
    @NotBlank(message = "Trường này không được để trống. (*)")
    private String employeeAddress;
    private String employeeImage;
    @NotBlank(message = "Trường này không được để trống. (*)")
    private String employeePhone;
    private String employeeStartDate;
    private String employeeNote;
    private String position;
    @NotBlank(message = "Trường này không được để trống. (*)")
    private String accountName;
    private boolean flag;
}
