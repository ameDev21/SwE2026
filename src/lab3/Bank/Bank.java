package Bank;

import java.util.ArrayList;

/**
 * Bank (Singleton)
 */
public class Bank {
  ArrayList<Account> accounts = new ArrayList<>();

  // this has to be checked with debugger for array size and indeces correctness
  public Account openAccount(String owner, long initial_balance) {
    this.accounts.add(this.accounts.size(), new Account(owner, initial_balance));
    return this.accounts.get(this.accounts.size() - 1);
  }

  public Account getAccount(int id) {
    for (Account account : this.accounts) {
      if (account.getId() == id) {
        return account;
      }
    }
    return null;
  }

  public long totalMoney() {
    long sum = 0;
    for (Account account : accounts) {
      sum += account.getBalance();
    }
    return sum;
  }
}
