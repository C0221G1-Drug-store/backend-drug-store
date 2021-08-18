package com.backend.pharmacy_management.model.service.impl;

import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.repository.ManufactureRepository;
import com.backend.pharmacy_management.model.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ManufactureImpl implements ManufacturerService {
    @Autowired
    private ManufactureRepository manufactureRepository;

    @Override
    public List<Manufacturer> findAllManufacturer() {
        return manufactureRepository.findAll();
    }
}
