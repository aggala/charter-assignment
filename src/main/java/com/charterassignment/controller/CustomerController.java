package com.charterassignment.controller;

import com.charterassignment.entity.Customer;
import com.charterassignment.entity.Transaction;
import com.charterassignment.service.CustomerService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class CustomerController {

  CustomerService customerService;

  @Autowired
  public CustomerController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping
  public ModelAndView customers (@ModelAttribute Customer customer) {
    List<Customer> customers = customerService.findAll();
    Map<String, Object> model = new HashMap<>();
    model.put("customers", customers);
    return new ModelAndView("customer", model);
  }

  @PostMapping("addCustomer")
  public ModelAndView addCustomer(Customer customer) {
    //create new customer.
    customerService.newCustomer(customer);
    return new ModelAndView("redirect:/");
  }
}
