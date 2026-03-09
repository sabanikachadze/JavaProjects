package BankingSystem;

public class InitialDepositCannotBeNegativeException extends BankingExceptions{
        public InitialDepositCannotBeNegativeException(String ownerName) {
        super(ownerName + " initialDeposit cannot be negative!");
    }
}
