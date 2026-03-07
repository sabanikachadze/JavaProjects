package BankAccount;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class BankAccount {
    final String accountNumber;
    String owner;
    private static final AtomicInteger counter = new AtomicInteger(0);
    private double balance;
    List<String> transactionHistory = new ArrayList<String>();

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = createSavings();
        this.owner = owner;
        this.balance = Math.max(balance,0);
    }

    public void transfer(BankAccount target, double amount) throws InsufficientFundsException {
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        if (balance - amount < 0) throw new InsufficientFundsException();
        transactionHistory.add(String.format("%s -%.2f | Balance: %.2f",time,amount,balance));
        target.deposit(amount);
        balance -= amount;
    }

    public void withDraw(double amount) throws InsufficientFundsException {
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        if (balance - amount < 0) throw new InsufficientFundsException();
        transactionHistory.add(String.format("%s -%.2f | Balance: %.2f",time,amount,balance));
        balance -= amount;
    }

    public void deposit(double amount) {
        LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        transactionHistory.add(String.format("%s +%.2f | Balance: %.2f",time,amount,balance));
        balance += amount;
    }
       private String createSavings() {
        int id = counter.incrementAndGet();
        return String.format("SAV-%04d", id);
    }
    
    public double getBalance()                  { return balance; }
    public String getAccountNumber()            { return accountNumber; }
    public String getOwner()                    { return owner; }
    public List<String> getTransactionHistory() { return transactionHistory; }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", transactionHistory=" + transactionHistory +
                '}';
    }
}
