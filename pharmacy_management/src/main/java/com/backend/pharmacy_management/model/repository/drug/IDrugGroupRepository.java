package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugGroupRepository extends PagingAndSortingRepository<DrugGroup, Long> {
}
