package com.backend.pharmacy_management.model.dto;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDto {
    Long paymentId ;
    Double totalMoney ;
    Double prepayment ;
    Integer discount ;
    String status ;
    ImportBill importBill;
}
