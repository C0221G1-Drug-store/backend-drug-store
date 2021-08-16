package com.backend.pharmacy_management.controller.drug_group;

import com.backend.pharmacy_management.model.entity.drug.DrugGroup;
import com.backend.pharmacy_management.model.service.drug_group.IDrugGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping(value = "/drugGroup")
public class DrugGroupController {
    @Autowired
    IDrugGroupService drugGroupService;
    @GetMapping(" ")
    public ResponseEntity<List<DrugGroup>> showDrugGroup() {
        List<DrugGroup> drugGroups = drugGroupService.findAll();
        if (drugGroups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(drugGroups, HttpStatus.OK);
        }
    }

    @GetMapping("/page")
    public ResponseEntity<Page<DrugGroup>> showDrugGroupPage(@PageableDefault(value = 5) Pageable pageable) {
        Page<DrugGroup> drugGroups = drugGroupService.findAllPage(pageable);
        if (drugGroups.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(drugGroups, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<DrugGroup> saveDrugGroup(@RequestBody DrugGroup drugGroup) {
        return new ResponseEntity<>(drugGroupService.save(drugGroup), HttpStatus.CREATED);
    }

    @PutMapping(value = "/edit/{drugGroupId}")
    public ResponseEntity<DrugGroup> updateDrugGroup(@PathVariable Long drugGroupId, @RequestBody DrugGroup drugGroup) {
        DrugGroup group = drugGroupService.findById(drugGroupId);
        if (drugGroup == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        drugGroup.setDrugGroupId(group.getDrugGroupId());
        return new ResponseEntity<>(drugGroupService.save(drugGroup), HttpStatus.OK);
    }
    @PatchMapping("/delete/{drugGroupId}")
    public ResponseEntity<DrugGroup> deleteDrugGroug(@PathVariable Long drugGroupId) {
        DrugGroup  drugGroup = drugGroupService.findById(drugGroupId);
        if (drugGroup == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        drugGroup.setFlag(false);
        drugGroupService.delete(drugGroup);
        return new ResponseEntity<>(drugGroup, HttpStatus.NO_CONTENT);
    }
}
