package com.charterassignment;
// A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.
//
// A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point
// for every dollar spent over $50 in each transaction
//
// (e.g.a $120 purchase = 2x$20 + 1x$50 = 90 points)
// Given a record of every transaction during a three month period, calculate the reward points earned
// for each customer per month and total.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.charterassignment.service.TransactionService;

@SpringBootApplication
public class CharterCodeAssignment {

  public static void main(String[] args) {
    SpringApplication.run(CharterCodeAssignment.class);
//    TransactionService transactionService = new TransactionService();
//    Customer A = new Customer(1);
//    Transaction transaction = new Transaction(120.0, LocalDate.now());
//    Transaction transaction1 = new Transaction(1200.0, LocalDate.now().minusDays(35));
//    Transaction transaction2 = new Transaction(240.0, LocalDate.now().minusDays(65));
//    Transaction transaction3 = new Transaction(120.0, LocalDate.now().minusDays(1));
//    Transaction transaction4 = new Transaction(51.1, LocalDate.now().minusDays(1));
//    List<Transaction> transactionsByA = Arrays.asList(transaction, transaction1, transaction2, transaction3, transaction4);
//    A.setTransactions(transactionsByA);
//    System.out.println("A's transactions: " + A.getTransactions());
//    System.out.println("total rewards earned by A: " + transactionService.calculateTotalReward(A.getTransactions()));
//    System.out.println("A's reward for 8 month of 2021: " + transactionService.calculateMonthlyReward(A.getTransactions(), 8));
//    System.out.println("A's monthly rewards: " + transactionService.totalRewardGroupedByMonth(A.getTransactions()));
//    Double amtSpent = transactionService.totalAmountSpentInMonth(A.getTransactions(), 8);
//    System.out.println("Amount spent in 8 month:" + amtSpent);
//    System.out.println("Reward earned based on monthly spend: " + transactionService.rewardForAmount(amtSpent));
//
//    System.out.println();
//
//    Customer B = new Customer(2);
//    Transaction transaction5 = new Transaction(101.50, LocalDate.of(2021, 1, 1));
//    Transaction transaction6 = new Transaction(51.0, LocalDate.of(2021, 1, 12));
//    Transaction transaction7 = new Transaction(101.0, LocalDate.of(2021, 2, 19));
//    Transaction transaction8 = new Transaction(201.0, LocalDate.of(2021, 2, 28));
//    Transaction transaction9 = new Transaction(50.2, LocalDate.of(2021, 3, 10));
//    List<Transaction> transactionByB = Arrays.asList(transaction5, transaction6, transaction7, transaction8, transaction9);
//    B.setTransactions(transactionByB);
//    System.out.println("B's transactions: " + B.getTransactions());
//    System.out.println("total rewards earned by B: " + transactionService.calculateTotalReward(B.getTransactions()));
//    System.out.println("B's reward for 3 month of 2021: " + transactionService.calculateMonthlyReward(B.getTransactions(), 3));
//    System.out.println("B's monthly rewards: " + transactionService.totalRewardGroupedByMonth(B.getTransactions()));
//    amtSpent = transactionService.totalAmountSpentInMonth(B.getTransactions(), 3);
//    System.out.println("Amount spent in 3 month " + amtSpent);
//    System.out.println("Reward earned based on monthly spend: " + transactionService.rewardForAmount(amtSpent));



  }

}
