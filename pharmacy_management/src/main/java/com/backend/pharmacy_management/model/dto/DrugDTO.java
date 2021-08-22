package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

public interface DrugDTO {
    String getDrugId();

    String getDrugCode();

    String getDrugName();

    String getActiveElement();

    String getUnit();

    String getConversionUnit();

    String getConversionRate();

    String getWholesaleProfitRate();

    String getRetailProfitRate();

    String getDrugFaculty();

    String getManufacturer();

    String getOrigin();

    String getNote();

    String getDrugSideEffect();

    String getFlag();

    String getDrugGroupId();
}

