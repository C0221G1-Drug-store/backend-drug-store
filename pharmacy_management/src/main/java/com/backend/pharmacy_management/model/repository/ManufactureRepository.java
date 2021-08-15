package com.backend.pharmacy_management.model.repository;

import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufactureRepository extends JpaRepository<Manufacturer,Long> {
}
