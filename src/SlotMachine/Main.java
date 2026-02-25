package SlotMachine;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static int balance = 100;
    static int bet;
    static int profits;
    static String[] slotSymbols = new String[]{"🍒", "🍋", "🍇", "💎", "🍀"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        if (playGame(scanner)) {
            System.out.println("balance: $" + balance);
            while (balance > 0) {
                if (placeBet(scanner)) {
                    updateBalance(spinSlot(random));
                    printInfo();
                } else {
                    continue;
                }
                if (balance == 0) break;
                System.out.print("Would you like to play again?(YES|NO):");
                if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                    System.out.println();
                    break;
                }
            }
        }
        if (balance == 0) {
            System.out.println("You've run out of money!");
        }
        System.out.println("Well... see you soon!");
        scanner.close();
    }

    public static boolean playGame(Scanner scanner) {
        System.out.println("************************");
        System.out.println("  Welcome to Java Slots  ");
        System.out.println("Symbols: 🍀 💎 🍋 🍒 🍇");
        System.out.println("************************");
        System.out.print("Would you like to play?(YES|NO): ");
        return scanner.nextLine().equalsIgnoreCase("yes");
    }

    public static boolean placeBet(Scanner scanner) {
        System.out.print("Enter your bet amount: ");
        bet = scanner.nextInt();
        scanner.nextLine();
        if (bet > balance) {
            System.out.println("Your bet exceeds current balance!");
            return false;
        } else if (bet <= 0) {
            System.out.println("Bet cannot be zero or negative!");
            return false;
        } else {
            balance -= bet;
            return true;
        }
    }

    public static int spinSlot(Random random) {
        String[] currentSlot = new String[3];
        for (int i = 0; i < 3; i++) {
            currentSlot[i] = slotSymbols[random.nextInt(slotSymbols.length)];
        }
        printSlotSymbols(currentSlot);
        return getPayout(currentSlot, bet);
    }
    public static int getPayout(String[] row, int bet) {
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch (row[0]) {
                case "🍒" -> bet * 3;
                case "🍋" -> bet * 5;
                case "🍇" -> bet * 7;
                case "💎" -> bet * 10;
                case "🍀" -> bet * 20;
                default -> 0;
            };
        } else if (row[0].equals(row[1]) || row[1].equals(row[2]) || row[0].equals(row[2])) {
            String match = row[0].equals(row[1]) ? row[0] : row[1].equals(row[2]) ? row[1] : row[0];
            return switch (match) {
                case "🍒" -> bet;
                case "🍋" -> bet * 2;
                case "🍇" -> bet * 3;
                case "💎" -> bet * 4;
                case "🍀" -> bet * 5;
                default -> 0;
            };
        }
        return 0;
    }

    public static void updateBalance(int amount) {
        profits = amount;
        balance += amount;
    }

    public static void printInfo() {
        if (profits == 0) {
            System.out.printf("%nYou lost your bet of $%d%n", bet);
        } else {
            System.out.printf("%nYour bet was - $%d : You won - $%d%n", bet, profits);
        }
        System.out.printf("Your current balance is | $%d |%n", balance);
    }

    public static void printSlotSymbols(String[] currentSlot) {
        System.out.printf("%n|%s - %s - %s |", currentSlot[0], currentSlot[1], currentSlot[2]);
    }
}