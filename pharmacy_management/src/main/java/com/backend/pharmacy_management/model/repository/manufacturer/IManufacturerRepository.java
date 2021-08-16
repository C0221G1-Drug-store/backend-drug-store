package com.backend.pharmacy_management.model.repository.manufacturer;

import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}
