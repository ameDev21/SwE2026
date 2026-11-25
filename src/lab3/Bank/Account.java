package Bank;

import Bank.Handlers.InsufficientFundsException;

public class Account {
  private static int id_counter = 0;
  private int id;
  private String owner;
  private long balance;

  public Account(String owner, long balance) {
    this.id = Account.id_counter + 1;
    Account.id_counter++;
    this.owner = owner;
    this.balance = balance;
  }

  public void deposit(long amount) {
    if (amount > 0) {
      this.balance += amount;
    } else {

    }
  }

  public void withdraw(long amount) throws InsufficientFundsException {
    if (amount < this.getBalance()) {
      this.balance -= amount;
    } else {
      throw new InsufficientFundsException("Withdrawal amount exteeds avaliable funds \n");
    }
  }

  public long getBalance() {
    return this.balance;
  }

  public int getId() {
    return id;
  }

  public String getOwner() {
    return owner;
  }

}
