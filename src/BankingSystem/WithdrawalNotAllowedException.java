package BankingSystem;

import java.time.LocalDate;

public class WithdrawalNotAllowedException extends BankingExceptions {
    public WithdrawalNotAllowedException(LocalDate maturityDate) {
        super("Cannot withdraw before maturity date: " + maturityDate);
    }
}