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

  public Integer calculateMonthlyReward(List<Transaction> allTransactions, Integer month) {
    int monthlyReward = 0;

    for (Transaction transaction : allTransactions) {
      if (transaction.getTransactionDate().getMonthValue() == month) {
        monthlyReward += transaction.getReward();
      }
    }

    return monthlyReward;
  }

  public Double totalAmountSpentInMonth (List<Transaction> allTransactions, Integer month) {
    Double totalAmountSpent = 0.0d;

    for (Transaction transaction : allTransactions) {
      if (transaction.getTransactionDate().getMonthValue() == month) {
        totalAmountSpent += transaction.getTransactionAmount();
      }
    }

    return totalAmountSpent;
  }

  public Integer rewardForAmount (Double amount) {
    if (amount > 100) {
      return ((int)Math.floor(amount) - 100) * 2 + 50;
    }

    if (amount > 50) {
      return  (int)Math.floor(amount) - 50;
    }

    return 0;
  }

  /**
   * Gets rewards earned each month.
   * @param allTransactions
   * @return
   */
  public Map<Integer, Integer> totalRewardGroupedByMonth(List<Transaction> allTransactions) {
    Map<Integer, Integer> rewardGroupedByMonth = new HashMap<>();

    for (Transaction transaction : allTransactions) {
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

  public Integer calculateTotalReward(List<Transaction> allTransactions) {

    return allTransactions.stream().mapToInt(Transaction::getReward).sum();

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
