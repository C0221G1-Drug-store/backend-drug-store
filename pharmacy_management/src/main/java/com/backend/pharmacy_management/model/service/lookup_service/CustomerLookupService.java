package com.backend.pharmacy_management.model.service.lookup_service;

import com.backend.pharmacy_management.model.dto.lookup.CustomerLookup;
import com.backend.pharmacy_management.model.dto.lookup.ManufacturerLookup;
import com.backend.pharmacy_management.model.entity.customer.CustomerGroup;
import com.backend.pharmacy_management.model.repository.ICustomerGroupRepo;
import com.backend.pharmacy_management.model.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CustomerLookupService implements ICustomerLookupService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    ICustomerGroupRepo iCustomerGroupRepo;
    @Autowired
    ICustomerRepo iCustomerRepo;
    @Override
    public List<CustomerGroup> findAllCustomerGroup() {
        return iCustomerGroupRepo.findAll();
    }

    @Override
    public List<ManufacturerLookup> findManufacturerByKey(String code, String name, String address, String phone) {
        String sql = "select * " +
                "from pharmacy_management.manufacturer " +
                "where (manufacturer_code like ?) " +
                "and (manufacturer_name like ?) " +
                "and (manufacturer_address like ?) " +
                "and (manufacturer_phone_number like ?) ";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, code, name, address, phone);
        List<ManufacturerLookup> list = new ArrayList<>();
        ManufacturerLookup manufacturerLookup;
        for (Map<String, Object> row : rows) {
            String code1 = (String) row.get("manufacturer_code");
            String name1 = (String) row.get("manufacturer_name");
            String address1 = (String) row.get("manufacturer_address");
            String phone1 = (String) row.get("manufacturer_phone_number");
            String note = (String) row.get("manufacturer_note");
            manufacturerLookup = new ManufacturerLookup(code1, name1, address1, phone1, note);
            list.add(manufacturerLookup);
        }
        return list;
    }

    @Override
    public List<CustomerLookup> findByKey(String code, String name, String address, String phone, String groupId) {
        String sql = "select * " +
                "from pharmacy_management.customer " +
                "where (customer_code like ?) " +
                "and (customer_name like ?) " +
                "and (customer_address like ?) " +
                "and (customer_phone like ?) " +
                "and (customer_group_id like ?) " +
                "group by customer_id ";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, code, name, address, phone, groupId);
        List<CustomerLookup> list = new ArrayList<>();
        CustomerLookup customerLookup;
        for (Map<String, Object> row : rows) {
            String code1 = (String) row.get("customer_code");
            String name1 = (String) row.get("customer_name");
            String age = (String) row.get("customer_age");
            String address1 = (String) row.get("customer_address");
            String phone1 = (String) row.get("customer_phone");
            Long group = (Long) row.get("customer_group_id");
            String note = (String) row.get("customer_node");
            customerLookup = new CustomerLookup(code1, name1, age, address1, phone1, group.toString(), note);
            list.add(customerLookup);
        }
        return list;
    }
}
