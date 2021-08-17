package com.charterassignment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "transaction_amount")
  private Double transactionAmount;

  @Column(name = "transaction_date")
  private LocalDate transactionDate;

  @Column(name = "reward")
  private Integer reward;

  @JsonIgnore
  @ManyToOne
  private Customer customer;

  public Transaction () {}

  public Long getId() {
    return id;
  }

  public void setTransactionAmount (Double transactionAmount) {
    this.transactionAmount = transactionAmount;
    calculateReward();
  }

  public void setTransactionDate (LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }

  public Double getTransactionAmount () {
    return transactionAmount;
  }

  public LocalDate getTransactionDate () {
    return transactionDate;
  }

  public Integer getReward () {
    return reward;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void calculateReward () {
    if (transactionAmount > 100) {
      reward = ((int)Math.floor(transactionAmount) - 100) * 2 + 50;
      return;
    }

    if (transactionAmount > 50) {
      reward = (int)Math.floor(transactionAmount) - 50;
      return;
    }

    reward = 0;
  }

  public String toString() {
    return "date:" + transactionDate + ", amount: " + transactionAmount + ", reward: " + reward;
  }
}
