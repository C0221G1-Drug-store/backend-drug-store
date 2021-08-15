package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDrugRepository extends PagingAndSortingRepository<Drug, Long> {
    @Query(value = "select d from Drug d where d.flag = true", nativeQuery = false)
    Page<Drug> findAllDrugs(Pageable pageable);
}
