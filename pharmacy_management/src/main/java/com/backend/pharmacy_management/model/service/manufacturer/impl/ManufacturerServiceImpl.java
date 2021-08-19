package com.backend.pharmacy_management.model.service.manufacturer.impl;

import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.repository.manufacturer.ManufacturerRepository;
import com.backend.pharmacy_management.model.service.manufacturer.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements IManufacturerService {
    @Autowired
    ManufacturerRepository manufacturerRepository;

    @Override
    public Page<Manufacturer> findAllManufacturer(Pageable pageable) {
        return manufacturerRepository.findAllManufacturer(pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerName(String name,Pageable pageable ) {
        return manufacturerRepository.findByManufacturerName( name,pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerCode( String code,Pageable pageable) {
        return manufacturerRepository.findByManufacturerCode( code,pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerAddress(String address,Pageable pageable ) {
        return manufacturerRepository.findByManufacturerAddress( address,pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerPhoneNumber(String phoneNumber,Pageable pageable ) {
        return manufacturerRepository.findByManufacturerPhoneNumber(phoneNumber,pageable);
    }

    @Override
    public Manufacturer findByManufacturerId(Long id) {
        return manufacturerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Manufacturer> findByManufacturerNote( String node,Pageable pageable) {
        return manufacturerRepository.findByManufacturerNote( node,pageable);
    }

    @Override
    public void saveManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);


    }

    @Override
    public void deleteManufacturer(Long id) {
        manufacturerRepository.deleteById(id);
    }

    @Override
    public Page<Manufacturer> findAllSortName(Pageable pageable) {
        return manufacturerRepository.findAllSortName(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortCode(Pageable pageable) {
        return manufacturerRepository.findAllSortCode(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortAddress(Pageable pageable) {
        return manufacturerRepository.findAllSortAddress(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortNote(Pageable pageable) {
        return manufacturerRepository.findAllSortNote(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortPhoneNumber(Pageable pageable) {
        return manufacturerRepository.findAllSortPhoneNumber(pageable);
    }

    @Override
    public Page<Manufacturer> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Manufacturer> findById(Long id) {
        return this.manufacturerRepository.findById(id);
    }

    @Override
    public List<Manufacturer> findAllNormal() {
        return manufacturerRepository.findAllNormal();
    }

    @Override
    public void save(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }

    @Override
    public void remove(Long id) {
        manufacturerRepository.deleteById(id);
    }
}
