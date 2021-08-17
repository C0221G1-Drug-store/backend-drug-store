package com.backend.pharmacy_management.model.service.customer;

import com.backend.pharmacy_management.model.dto.lookup.CustomerLookup;
import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.repository.ICustomerGroupRepo;
import com.backend.pharmacy_management.model.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepo customerRepo;

    @Override
    public Page<Customer> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return customerRepo.findById(id);
    }

    @Override
    public List<Customer> findAllNormal() {
        return customerRepo.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        Customer customer = this.findById(id).orElse(null);
        customer.setFlag(false);
        this.save(customer);
    }

    @Override
    public List<Customer> findALlBySearch(String keyWord) {
//        return customerRepo.findALlBySearch(keyWord);
        return null;
    }

    @Override
    public List<CustomerLookup> findALlBySearch(String code, String name, String address, String phone, String groupId) {
        return null;
    }
}
