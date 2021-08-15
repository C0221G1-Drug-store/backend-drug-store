package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.entity.drug.DrugDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDrugRepository extends PagingAndSortingRepository<Drug, Long> {
    @Query(value = "select d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, d.drug_amount as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.drug_side_effect as drugSideEffect\n" +
            "from drug d \n" +
            "left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "where d.flag = 1 limit 0,2;", nativeQuery = true)
//@Query(value = "select d from Drug d where d.flag = true", nativeQuery = false)
    List<DrugDTO> findAllDrugs(int index);

    @Query(value = "select d from Drug d where d.flag = true", nativeQuery = false)
    Iterable<Drug> findAll();
}
