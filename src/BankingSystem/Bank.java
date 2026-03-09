package BankingSystem;

import java.util.ArrayList;

public class Bank {
    private final String bankName = "Tabakinis banki";
    private ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public boolean addAccount(BankAccount account){
        if(account == null) return false;
        bankAccounts.add(account);
        return true;
    }

    public BankAccount findByNumber(String accountNumber) throws AccountNotFoundException{
        for(BankAccount account : bankAccounts){
            if(account.getAccountNumber().equals(accountNumber)) return account;
        }
        throw new AccountNotFoundException("Wrong account number!");
    }

    public void transfer(String fromNumber, String toNumber, double amount) throws BankingExceptions {
        BankAccount from = findByNumber(fromNumber);
        BankAccount to   = findByNumber(toNumber);
        from.withdraw(amount);
        to.deposit(amount);

        System.out.println("Transferred $" + amount + " | " + fromNumber + " → " + toNumber);
    }

    public void printSummaries(){
        System.out.println(bankName);
        int count = 0;

        for(BankAccount account : bankAccounts){
            count++;
            System.out.println(account.toString());
            System.out.println("---------------");
        }
        System.out.println("Total accounts - " + count);

    }



}
