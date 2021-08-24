package com.backend.pharmacy_management.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
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
    private boolean flag = true;

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

}
