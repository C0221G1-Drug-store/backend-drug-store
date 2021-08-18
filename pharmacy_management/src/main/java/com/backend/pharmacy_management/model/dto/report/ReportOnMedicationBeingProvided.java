package com.backend.pharmacy_management.model.dto.report;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReportOnMedicationBeingProvided {
    private String tenThuoc;
    private String hoatChat;
    private String tacDungPhu;
    private String nguonGoc;
    private String nhaCungCap;
    private String ghiChu;

}
