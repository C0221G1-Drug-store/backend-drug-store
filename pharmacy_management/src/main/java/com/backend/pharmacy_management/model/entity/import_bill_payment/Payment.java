package com.backend.pharmacy_management.model.entity.import_bill_payment;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long paymentId ;
    Double totalMoney ;
    Double prepayment ;
    Integer discount ;
    String status ;
    @OneToOne(mappedBy = "payment")
//    @JsonManagedReference
    ImportBill importBill;

}
