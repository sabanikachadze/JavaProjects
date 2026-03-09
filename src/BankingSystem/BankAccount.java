package BankingSystem;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class BankAccount {
    private static final AtomicInteger counter = new AtomicInteger(0);
    private String accountNumber;
    private String ownerName;
    private double balance = 0;

    public BankAccount(String ownerName, double initialDeposit, String prefix) throws BankingExceptions {
        this.accountNumber = String.format(prefix + "-%04d", counter.incrementAndGet());
        this.ownerName = ownerName;
        initialDepositCheck(initialDeposit);
        this.balance = initialDeposit;
    }

    public void deposit(double amount) throws BankingExceptions {
        if (amount < 0) throw new BankingExceptions("Deposit cannot be negative");
        balance += amount;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    abstract public void withdraw(double amount) throws BankingExceptions;

    private void initialDepositCheck(double amount) throws InitialDepositCannotBeNegativeException {
        if (amount < 0) throw new InitialDepositCannotBeNegativeException(ownerName);
    }


    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "accountNumber='" + accountNumber + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", balance= " + balance +
                '}';
    }
}
