package Entity;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private int id;
  private List<Transaction> transactions;

  public Customer () {}
  public Customer (int id) {
    this.id = id;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public void addTransaction (Transaction transaction) {
    if (transactions == null) {
      transactions = new ArrayList<>();
    }
    transactions.add(transaction);
  }
}
