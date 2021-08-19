package com.backend.pharmacy_management.model.service;

import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    List<Manufacturer> findAllManufacturer();
}
