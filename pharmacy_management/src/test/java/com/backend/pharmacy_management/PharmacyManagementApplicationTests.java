package com.backend.pharmacy_management;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PharmacyManagementApplicationTests {

    @Test
    void contextLoads() {
        Assertions.assertDoesNotThrow(this::doNotThrowException);
    }
    private void doNotThrowException(){

    }
}
