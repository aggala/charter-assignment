package com.charterassignment.controller;

import com.charterassignment.entity.Customer;
import com.charterassignment.entity.Transaction;
import com.charterassignment.service.CustomerService;
import com.charterassignment.service.TransactionService;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

  TransactionService transactionService;
  CustomerService customerService;

  @Autowired
  public TransactionController(TransactionService transactionService, CustomerService customerService) {
    this.transactionService = transactionService;
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ModelAndView getTransactions(@PathVariable Long customerId) {
    Customer customer = customerService.getCustomer(customerId);
    List<Transaction> transactions = transactionService.getTransactions(customerId);
    Map<String, Object> model = new HashMap<>();
    model.put("transactions", transactions);
    model.put("customerId", customerId);
    model.put("customerName", customer.getName());
    return new ModelAndView("transactions", model);

  }

  @PostMapping("/addTransaction")
  public ModelAndView addTransaction( @RequestParam(value = "customerId") Long customerId,
      @RequestParam(value = "transactionDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate transactionDate,
      @RequestParam(value = "transactionAmount") Double transactionAmount) {
    System.out.println("custId: " + customerId + " tranDate: " + transactionDate + " tranAmt: " + transactionAmount);
    transactionService.addTransaction(customerId, transactionDate, transactionAmount);
    return new ModelAndView("redirect:/transactions/" + customerId);
  }

}
