package com.backend.pharmacy_management.model.entity.drug;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DrugDTO {
    private String drugId;
    private String drugCode;
    private String drugName;
    private String activeElement;
    private String drugAmount;
    private String unit;
    private String conversionUnit;
    private String conversionRate;
    private String wholesaleProfitRate;
    private String retailProfitRate;
    private String drugFaculty;
    private String manufacturer;
    private String origin;
    private String note;
    private String drugSideEffect;
    private String flag;

}

