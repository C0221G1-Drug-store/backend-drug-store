package com.backend.pharmacy_management.model.repository.manufacturer;


import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ManufacturerRepository extends PagingAndSortingRepository<Manufacturer, Long> {
    @Query(value = "select * from manufacturer where flag = 1", nativeQuery = true)
    Page<Manufacturer> findAllManufacturer(Pageable pageable);

    @Query(value = "select * from manufacturer where manufacturer_code like %?1%", nativeQuery = true)
    Page<Manufacturer> findByManufacturerCode(String code, Pageable pageable);

    @Query(value = "select * from manufacturer where manufacturer_name like %?1%", nativeQuery = true)
    Page<Manufacturer> findByManufacturerName(String name, Pageable pageable);

    @Query(value = "select * from manufacturer where manufacturer_address like %?1%", nativeQuery = true)
    Page<Manufacturer> findByManufacturerAddress(String address, Pageable pageable);

    @Query(value = "select * from manufacturer where manufacturer_note like %?1%", nativeQuery = true)
    Page<Manufacturer> findByManufacturerNote(String node, Pageable pageable);

    @Query(value = "select * from manufacturer where manufacturer_phone_number like %?1%", nativeQuery = true)
    Page<Manufacturer> findByManufacturerPhoneNumber(String phoneNumber, Pageable pageable);


    @Query(value = "select * from manufacturer order by manufacturer_name", nativeQuery = true)
    Page<Manufacturer> findAllSortName(Pageable pageable);
    @Query(value = "select * from manufacturer order by manufacturer_code", nativeQuery = true)
    Page<Manufacturer> findAllSortCode(Pageable pageable);
    @Query(value = "select * from manufacturer order by manufacturer_address", nativeQuery = true)
    Page<Manufacturer> findAllSortAddress(Pageable pageable);
    @Query(value = "select * from manufacturer order by manufacturer_note", nativeQuery = true)
    Page<Manufacturer> findAllSortNote(Pageable pageable);
    @Query(value = "select * from manufacturer order by manufacturer_phone_number", nativeQuery = true)
    Page<Manufacturer> findAllSortPhoneNumber(Pageable pageable);
    @Query(value= "update manufacturer set flag = 0 WHERE manufacturer_id = ?1 ", nativeQuery = true)
    void deleteByIdManufacturer(Long id);

}
