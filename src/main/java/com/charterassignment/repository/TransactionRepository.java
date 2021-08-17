package com.charterassignment.repository;

import com.charterassignment.entity.Transaction;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
  List<Transaction> findAllByCustomerIdOrderById(Long customerId);

}
