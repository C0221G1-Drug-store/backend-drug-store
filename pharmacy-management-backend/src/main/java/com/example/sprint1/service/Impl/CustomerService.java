package com.example.sprint1.service.Impl;

import com.example.sprint1.model.Customer;
import com.example.sprint1.repository.CustomerRepository;
import com.example.sprint1.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getAllCustomer() {
        return this.customerRepository.getAllCustomer();
    }

    @Override
    public List<Customer> getCustomerPagination(int index) {
        return this.customerRepository.getCustomerPagination(index);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return this.customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> findCustomerBySearch( String keyWord) {
        return this.customerRepository.findCustomerBySearch(keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerCode(int index,String keyWord) {
        return this.customerRepository.findCustomerByCustomerCode(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerGroup(int index,String keyWord) {
        return this.customerRepository.findCustomerByCustomerGroup(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerName(int index,String keyWord) {
        return this.customerRepository.findCustomerByCustomerName(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerAddress(int index,String keyWord) {
        return this.customerRepository.findCustomerByCustomerAddress(index,keyWord);
    }

    @Override
    public List<Customer> findCustomerByCustomerPhone(int index,String keyWord) {
        return this.customerRepository.findCustomerByCustomerPhone(index,keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerCode(String keyWord) {
        return this.customerRepository.findNumberOfRecordCustomerCode(keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerName(String keyWord) {
        return this.customerRepository.findNumberOfRecordCustomerName(keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerAddress(String keyWord) {
        return this.customerRepository.findNumberOfRecordCustomerAddress(keyWord);
    }

    @Override
    public Integer findNumberOfRecordCustomerPhone(String keyWord) {
        return this.customerRepository.findNumberOfRecordCustomerPhone(keyWord);
    }


}
