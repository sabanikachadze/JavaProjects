package BankingSystem;

import java.time.LocalDate;

public class FixedDepositAccount extends BankAccount {
    private final LocalDate maturityDate;

    public FixedDepositAccount(String ownerName,
                                double initialDeposit, LocalDate maturityDate) throws BankingExceptions {
        super(ownerName, initialDeposit, "FXD");
        this.maturityDate = maturityDate;
    }

    @Override
    public void withdraw(double amount) throws WithdrawalNotAllowedException{

        if (LocalDate.now().isBefore(maturityDate)) {
            throw new WithdrawalNotAllowedException(maturityDate);
        }
        setBalance(getBalance() - amount);
    }
}