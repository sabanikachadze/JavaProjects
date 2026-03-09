package BankingSystem;

public class CheckingAccount extends BankAccount {
    private final double overdraftLimit;
    public CheckingAccount(String ownerName,
                           double initialDeposit, double overdraftLimit) throws BankingExceptions {
        super(ownerName, initialDeposit, "CHK");
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (getBalance() - amount < overdraftLimit)
            throw new InsufficientFundsException("overdraftLimit is reached, Cannot withdraw more!");
        setBalance(getBalance() - amount);
    }
}
