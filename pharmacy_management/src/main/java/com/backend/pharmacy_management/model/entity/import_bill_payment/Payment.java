package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId ;
    private Double totalMoney ;
    private Double prepayment ;
    private Integer discount ;
    private String status ;

    @OneToOne(mappedBy = "payment")
    ImportBill importBill;

}
