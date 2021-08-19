package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.entity.drug.DrugImageDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDrugImageDetailRepository extends JpaRepository<DrugImageDetail, Long> {
}
