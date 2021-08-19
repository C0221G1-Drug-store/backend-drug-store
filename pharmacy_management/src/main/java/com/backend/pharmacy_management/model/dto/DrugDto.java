package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DrugDto {
    private Long drugId;
    private String drugCode;
    private String drugName;
    private String activeElement;
    private Long drugAmount;
    private String unit;
    private String conversionUnit;
    private Integer conversionRate;
    private Double wholesaleProfitRate;
    private Double retailProfitRate;
    private String drugFaculty;
    private String drugSideEffect;
    private Boolean flag = true;
    private String manufacturer;
    private String origin;
    private String note;

    private DrugGroup drugGroup;
}
