package BankingSystem;

public class SavingsAccount extends BankAccount{
    private final double minBalance;
    public SavingsAccount(String ownerName,
                          double initialDeposit, double minBalance) throws BankingExceptions {
        super(ownerName, initialDeposit, "SAV");
        this.minBalance = minBalance;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException{
        if(getBalance() - amount < minBalance) throw new InsufficientFundsException("minBalance limit was reached, your account cannot go below the: " + minBalance);
        setBalance(getBalance() - amount);
    }
}
