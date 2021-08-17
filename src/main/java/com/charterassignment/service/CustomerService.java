package com.charterassignment.service;

import com.charterassignment.entity.Customer;
import com.charterassignment.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  CustomerRepository customerRepository;

  @Autowired
  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<Customer> findAll () {
    return customerRepository.findAll();
  }

  public Customer newCustomer(Customer customer) {
    customer.setTransactions(new ArrayList<>());
    return customerRepository.save(customer);
  }

  public Customer getCustomer(Long customerId) {
    return customerRepository.getOne(customerId);
  }
}
