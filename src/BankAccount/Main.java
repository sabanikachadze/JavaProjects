package BankAccount;



public class Main {
    public static void main(String[] args) {
        BankAccount bankAcc = new BankAccount("515423", "Saba", 500);
        try{
        bankAcc.withDraw(410);
        bankAcc.deposit(637.24);
        }catch(InsufficientFundsException e){
            System.out.println("Not enough money in the balance");
        }
        System.out.println(bankAcc.toString());
        }
    }
