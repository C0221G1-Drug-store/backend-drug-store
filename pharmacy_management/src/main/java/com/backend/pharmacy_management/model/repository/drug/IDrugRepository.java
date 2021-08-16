package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDrugRepository extends PagingAndSortingRepository<Drug, Long> {
    @Query(value = "select d from Drug d where d.flag = true", nativeQuery = false)
    Page<Drug> findAllDrugs(Pageable pageable);

    @Query(value = "select d from Drug d where d.drugGroup.drugGroupName like %?1% or d.drugName like %?1%")
    public List<Drug> searchDrugs(String search);

    @Query(value = "select d from Drug d where d.drugGroup.drugGroupId = ?1")
    public List<Drug> findDrugByGroup(Long drugGroupId);
}
