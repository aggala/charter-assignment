package com.charterassignment.service;

import com.charterassignment.entity.Customer;
import com.charterassignment.entity.Transaction;
import com.charterassignment.repository.CustomerRepository;
import com.charterassignment.repository.TransactionRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;

  @Autowired
  TransactionRepository transactionRepository;

  public List<Customer> findAll () {
    return customerRepository.findAll();
  }

  public Customer newCustomer(Customer customer) {
    customer.setTransactions(new ArrayList<>());
    Transaction transaction = new Transaction();
    transaction.setTransactionDate(LocalDate.now());
    transaction.setTransactionAmount(121.0d);
    transaction.setCustomer(customer);
    customer.addTransaction(transaction);

    Customer persistedCutomer = customerRepository.save(customer);
    transactionRepository.save(transaction);

    return persistedCutomer;
  }
}
