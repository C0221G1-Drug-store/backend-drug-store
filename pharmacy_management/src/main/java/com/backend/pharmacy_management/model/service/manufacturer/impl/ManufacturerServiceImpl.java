package com.backend.pharmacy_management.model.service.manufacturer.impl;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.repository.manufacturer.ImportBillRepository;
import com.backend.pharmacy_management.model.repository.manufacturer.ManufacturerRepository;
import com.backend.pharmacy_management.model.service.manufacturer.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManufacturerServiceImpl implements IManufacturerService {
    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    ImportBillRepository importBillRepository;
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
    public Manufacturer findByManufacturerId(Integer id) {
        return manufacturerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Manufacturer> findByManufacturerNote( String node,Pageable pageable) {
        return manufacturerRepository.findByManufacturerNote( node,pageable);
    }

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
      return   manufacturerRepository.save(manufacturer);


    }

    @Override
    public void deleteManufacturer(Integer id) {
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
    public Page<ImportBill> findByIdManufacturer(Integer id,Pageable pageable) {
        return importBillRepository.findAllByImportBill(id,pageable);
    }

    @Override
    public ImportBill findByIdImportBill(Integer id) {
        return importBillRepository.findByIdImportBill(id);
    }

    @Override
    public Page<ImportBill> findByDateImportBill(Integer id,String startDate, String endDate,Pageable pageable) {
        return importBillRepository.findByDateImportBill(id,startDate,endDate,pageable);
    }

}
