package com.backend.pharmacy_management;

<<<<<<< HEAD
import org.junit.jupiter.api.Assertions;
=======
import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
>>>>>>> origin/HaLK
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class PharmacyManagementApplicationTests {

    @Test
    void contextLoads() {
<<<<<<< HEAD
        Assertions.assertDoesNotThrow(this::doNotThrowException);
=======
        ExportBill e = new ExportBill();
        assertNull(e.getExportBillCode());  // JUnit assertion
        assertThat(e.getExportBillCode()).isNull();  // Fest assertion
>>>>>>> origin/HaLK
    }
    private void doNotThrowException(){

<<<<<<< HEAD
    }
=======

>>>>>>> origin/HaLK
}
