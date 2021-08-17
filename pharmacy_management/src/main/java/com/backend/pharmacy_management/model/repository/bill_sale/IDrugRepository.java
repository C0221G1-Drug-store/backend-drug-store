package com.backend.pharmacy_management.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDrugRepository extends JpaRepository<Drug, Long> {
}
