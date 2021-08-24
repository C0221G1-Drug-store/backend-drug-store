package com.example.sprint1.service;

import com.example.sprint1.model.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ICustomerService {

    List<Customer> getAllCustomer();

    List<Customer> getCustomerPagination(int index);
    Customer findCustomerById(Long id);
    void save(Customer customer);
    List<Customer> findCustomerBySearch(String keyWord);

    List<Customer> findCustomerByCustomerCode(int index,String keyWord);
    List<Customer> findCustomerByCustomerGroup(int index,String keyWord);
    List<Customer> findCustomerByCustomerName(int index,String keyWord);
    List<Customer> findCustomerByCustomerAddress(int index,String keyWord);
    List<Customer> findCustomerByCustomerPhone(int index,String keyWord);


    Integer findNumberOfRecordCustomerCode(String keyWord);
    Integer findNumberOfRecordCustomerName(String keyWord);
    Integer findNumberOfRecordCustomerAddress(String keyWord);
    Integer findNumberOfRecordCustomerPhone(String keyWord);






}
