package com.backend.pharmacy_management.controller.prescription_indicative;

import com.backend.pharmacy_management.model.entity.indicative_prescription.Indicative;
import com.backend.pharmacy_management.model.service.prescription_indicative.IIndicativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "indicatives")
@CrossOrigin(origins = "http://localhost:4200/")
public class IndicativeController {
    @Autowired
    private IIndicativeService iIndicativeService;
    @GetMapping(value = "indicative-list")
    public ResponseEntity<List<Indicative>> showList() {
        List<Indicative> indicativeList = (List<Indicative>) iIndicativeService.findAll();
        if (indicativeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(indicativeList, HttpStatus.OK);
    }
    @PostMapping(value = "/indicative-create")
    public ResponseEntity saveIndicative(@RequestBody Indicative indicative) {
        return new ResponseEntity<>(iIndicativeService.save(indicative), HttpStatus.CREATED);
    }
}
