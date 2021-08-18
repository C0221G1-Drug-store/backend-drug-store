package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface IDrugRepository extends PagingAndSortingRepository<Drug, Long> {
    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/d.drug_amount)/d.conversion_rate) as retailPrice,\n" +
            " ibd.discount_rate as discountRate, ibd.vat as vat, ibd.import_price as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.flag as flag, dg.drug_group_name as drugGroup, d.drug_side_effect as drugSideEffect\n" +
            "from drug d \n" +
            "left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "where d.flag = 1 and ibd.flag = 1 " +
            "group by d.drug_id " +
            "order by d.drug_name limit ?1,5;", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsPagination(int index);

    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/d.drug_amount)/d.conversion_rate) as retailPrice,\n" +
            " ibd.discount_rate as discountRate, ibd.vat as vat, ibd.import_price as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.flag as flag, dg.drug_group_name as drugGroup, d.drug_side_effect as drugSideEffect\n" +
            "from drug d \n" +
            "left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "where d.flag = 1 and ibd.flag = 1 " +
            "group by d.drug_id " +
            "having :field like %:input% " +
            "order by d.drug_name limit :index,5;", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsLikePagination(String field, String input, String index);

    @Query(value = "call drug_search_patination (:field,:sign,:input,:index)", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsSearch(String field, String sign, String input, String index);
    @Query(value = "call drug_search_not_patination (:field,:sign,:input)", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsSearchNotPagination(String field, String sign, String input);
    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/d.drug_amount)/d.conversion_rate) as retailPrice,\n" +
            " ibd.discount_rate as discountRate, ibd.vat as vat, ibd.import_price as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.flag as flag, dg.drug_group_name as drugGroup, d.drug_side_effect as drugSideEffect\n" +
            "from drug d \n" +
            "left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "where d.flag = 1 and ibd.flag = 1 " +
            "group by d.drug_id;", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsNotPagination();

    @Query(value = "select d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.drug_group_id as drugGroupId, d.flag as flag, d.drug_side_effect as drugSideEffect\n" +
            "from drug d \n" +
            "where d.flag = 1 and d.drug_id = ?1 and ibd.flag = 1;", nativeQuery = true)
    DrugDTO findDrugById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update drug set flag = 0 where drug_id = ?1 ",nativeQuery = true)
    void deleteDrugById(Long id);
}
