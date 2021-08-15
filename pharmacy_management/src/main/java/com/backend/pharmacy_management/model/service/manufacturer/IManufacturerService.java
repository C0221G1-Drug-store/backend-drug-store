package com.backend.pharmacy_management.model.service.manufacturer;

import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IManufacturerService {
    Page<Manufacturer> findAllManufacturer(Pageable pageable);
    Page<Manufacturer> findByManufacturerName( String name,Pageable pageable);
    Page<Manufacturer> findByManufacturerCode(String code,Pageable pageable );
    Page<Manufacturer> findByManufacturerAddress( String address,Pageable pageable);
    Page<Manufacturer> findByManufacturerPhoneNumber( String phoneNumber,Pageable pageable);
    Manufacturer findByManufacturerId( Integer id);
    Page<Manufacturer> findByManufacturerNote( String note,Pageable pageable);
    void saveManufacturer(Manufacturer manufacturer);
    void deleteManufacturer(Integer id);

    Page<Manufacturer> findAllSortName(Pageable pageable);

    Page<Manufacturer> findAllSortCode(Pageable pageable);

    Page<Manufacturer> findAllSortAddress(Pageable pageable);

    Page<Manufacturer> findAllSortNote(Pageable pageable);

    Page<Manufacturer> findAllSortPhoneNumber(Pageable pageable);
}
