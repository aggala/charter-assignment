package com.charterassignment.service;

import com.charterassignment.entity.Customer;
import com.charterassignment.entity.Transaction;
import com.charterassignment.repository.CustomerRepository;
import com.charterassignment.repository.TransactionRepository;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

  TransactionRepository transactionRepository;
  CustomerRepository customerRepository;

  @Autowired
  public TransactionService(TransactionRepository transactionRepository, CustomerRepository customerRepository) {
    this.transactionRepository = transactionRepository;
    this.customerRepository = customerRepository;
  }

  public List<Transaction> getTransactions(Long customerId) {
    return transactionRepository.findAllByCustomerIdOrderById(customerId);
  }

  public Map<Integer, Integer> totalRewardGroupedByMonth(Long customerId) {

    List<Transaction> transactions = transactionRepository.findAllByCustomerIdOrderById(customerId);
    Map<Integer, Integer> rewardGroupedByMonth = new HashMap<>();

    for (Transaction transaction : transactions) {
      Integer monthValue = transaction.getTransactionDate().getMonthValue();
      if (rewardGroupedByMonth.containsKey(monthValue)) {
        Integer updatedReward = rewardGroupedByMonth.get(monthValue) + transaction.getReward();
        rewardGroupedByMonth.put(monthValue, updatedReward);
      } else {
        rewardGroupedByMonth.put(monthValue, transaction.getReward());
      }
    }

    return rewardGroupedByMonth;
  }

  public Double calculateTotalSpent (Long customerId) {
    return transactionRepository.totalAmountSpendByCustomer(customerId);
  }

  public Integer calculateTotalReward(Long customerId) {
    return transactionRepository.totalRewardEarnedByCustomer(customerId);
  }

  public void addTransaction( Long customerId, LocalDate transactionDate, Double transactionAmount) {
    Customer customer = customerRepository.getOne(customerId);
    Transaction transaction = new Transaction();
    transaction.setTransactionAmount(transactionAmount);
    transaction.setTransactionDate(transactionDate);
    customer.addTransaction(transaction);
    transaction.setCustomer( customer);

    customerRepository.save(customer);
    transactionRepository.save(transaction);

  }
}
