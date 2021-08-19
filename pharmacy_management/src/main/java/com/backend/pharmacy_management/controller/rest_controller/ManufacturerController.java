package com.backend.pharmacy_management.controller.rest_controller;

import com.backend.pharmacy_management.model.dto.ManufacturerDto;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.service.manufacturer.IManufacturerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/manufacturer")
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
public class ManufacturerController {
    @Autowired
    IManufacturerService iManufacturerService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Manufacturer>> listManufacturer(@RequestParam Optional<String> address, @RequestParam Optional<String> name, @RequestParam Optional<String> note,
                                                               @RequestParam Optional<String> code, @RequestParam Optional<String> phoneNumber, @RequestParam Optional<String> sort, @RequestParam Integer page) {
        String name1 = "";
        String note1 = "";
        String phoneNumber1 = "";
        String code1 = "";
        String address1 = "";
        String sort1 = "";

        if (address.isPresent()) {
            address1 = address.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerAddress(address1, PageRequest.of(page, 2));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (name.isPresent()) {
            name1 = name.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerName(name1, PageRequest.of(page, 2));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (code.isPresent()) {
            code1 = code.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerCode(code1, PageRequest.of(page, 2));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (note.isPresent()) {
            note1 = note.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerNote(note1, PageRequest.of(page, 2));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (phoneNumber.isPresent()) {
            phoneNumber1 = phoneNumber.get();
            Page<Manufacturer> manufacturers = iManufacturerService.findByManufacturerPhoneNumber(phoneNumber1, PageRequest.of(page, 2));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        } else if (sort.isPresent()) {
            sort1 = sort.get();
            switch (sort1) {
                case "name": {

                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortName(PageRequest.of(page, 2));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "address": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortAddress(PageRequest.of(page, 2));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "note": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortNote(PageRequest.of(page, 2));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "code": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortCode(PageRequest.of(page, 2));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                case "phoneNumber": {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllSortPhoneNumber(PageRequest.of(page, 2));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
                default: {
                    Page<Manufacturer> manufacturers = iManufacturerService.findAllManufacturer(PageRequest.of(page, 2));
                    return new ResponseEntity<>(manufacturers, HttpStatus.OK);
                }
            }
        } else {
            Page<Manufacturer> manufacturers = iManufacturerService.findAllManufacturer(PageRequest.of(page, 2));
            return new ResponseEntity<>(manufacturers, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Manufacturer> createManufacturer(@RequestBody ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = new Manufacturer();
        BeanUtils.copyProperties(manufacturerDto, manufacturer);
        iManufacturerService.saveManufacturer(manufacturer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public void deleteManufacturer(@RequestParam Long id) {
        iManufacturerService.deleteManufacturer(id);
    }

    @PutMapping(value = "/update")
    public void updateManufacturer(@RequestParam Long id, @RequestBody ManufacturerDto manufacturerDto) {
        Manufacturer manufacturer = iManufacturerService.findByManufacturerId(id);
        BeanUtils.copyProperties(manufacturerDto, manufacturer);
        manufacturer.setManufacturerId(id);
        iManufacturerService.saveManufacturer(manufacturer);
    }
    @GetMapping(value = "/show")
    public ResponseEntity<Manufacturer> showManufacturer(@RequestParam Long id){
        return new ResponseEntity<>(iManufacturerService.findByManufacturerId(id), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Manufacturer>> getListNormals(){
        return new ResponseEntity<>(iManufacturerService.findAllNormal(), HttpStatus.OK);
    }
}
