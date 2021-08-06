package Entity;

import java.time.LocalDate;

public class Transaction {
  private Double transactionAmt;
  private LocalDate transactionDate;
  private Integer reward;

  public Transaction (Double transactionAmt, LocalDate transactionDate) {
    this.transactionAmt = transactionAmt;
    this.transactionDate = transactionDate;
    calculateReward();
  }

  public Transaction () {}

  public void setTransactionAmt (Double transactionAmt) {
    this.transactionAmt = transactionAmt;
    calculateReward();
  }

  public void setTransactionDate (LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }

  public Double getTransactionAmt () {
    return transactionAmt;
  }

  public LocalDate getTransactionDate () {
    return transactionDate;
  }

  public Integer getReward () {
    return reward;
  }

  public void calculateReward () {
    if (transactionAmt > 100) {
      reward = ((int)Math.floor(transactionAmt) - 100) * 2 + 50;
      return;
    }

    if (transactionAmt > 50) {
      reward = (int)Math.floor(transactionAmt) - 50;
      return;
    }

    reward = 0;
  }

  public String toString() {
    return "date:" + transactionDate + ", amount: " + transactionAmt + ", reward: " + reward;
  }
}
