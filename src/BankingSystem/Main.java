package BankingSystem;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {
            Bank bank = new Bank();
            CheckingAccount chAcc = new CheckingAccount("Vaska", 50 , -150);
            SavingsAccount savingsAcc = new SavingsAccount("Kako", 250, 0);
            FixedDepositAccount fixedAcc =
                    new FixedDepositAccount("Maxo", 100, LocalDate.of(2026, 3, 9));

            chAcc.deposit(50);
            fixedAcc.deposit(10);
            savingsAcc.deposit(50);

            chAcc.withdraw(25);
            fixedAcc.withdraw(50);
            savingsAcc.withdraw(20);

            bank.addAccount(chAcc);
            bank.addAccount(fixedAcc);
            bank.addAccount(savingsAcc);

            bank.transfer("SAV-0002","CHK-0001",45);

            bank.printSummaries();

        } catch (BankingExceptions e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
