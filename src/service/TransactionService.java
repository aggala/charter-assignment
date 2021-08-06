package service;

import Entity.Transaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {

  /**
   * If this app were connected to database and running as a service, this method would get all
   * transactions for current or month chosen.
   * In this instance I will be filtering transactions from list of all transactions.
   * @param allTransactions List of all transactions.
   * @param month           Month for which reward is supposed to be fetched.
   * @return                Total reward for the given month.
   */
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
        totalAmountSpent += transaction.getTransactionAmt();
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
}
