package com.charterassignment.repository;

import com.charterassignment.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findAllByCustomerIdOrderById(Long customerId);

  @Query("select sum(transactionAmount) from Transaction where customer.id = :customerId")
  Double totalAmountSpendByCustomer(@Param("customerId") Long customerId);

  @Query("select sum(reward) from Transaction where customer.id = :customerId")
  Integer totalRewardEarnedByCustomer(@Param("customerId") Long customerId);
}
