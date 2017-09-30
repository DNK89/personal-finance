package lv.dnk89.personalfinance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class PersonalFinanceApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add transaction to list
        // 2. Remove transaction from list
        // 3. Print transactions list to console
        // 4. Exit

        List<MoneyTransaction> transactions = new ArrayList<>();
        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            }
            switch (menuItem) {
                case 1: {
                    addTransactionToList(transactions);
                    break;
                }
                case 2: {
                    removeTransactionFromList(transactions);
                    break;
                }
                case 3: {
                    printTransactionListToConsole(transactions);
                    break;
                }
            }
        }
    }

    private static void printTransactionListToConsole(List<MoneyTransaction> transactions) {
        System.out.println();
        System.out.println("Transaction list START >>>");
        System.out.println();

        BigDecimal total = new BigDecimal(0);
        for (MoneyTransaction tran: transactions) {
            System.out.println(String.format("%2d) %7.2f %-25s", tran.getId(), tran.getAmount(), tran.getDescription()));
            total = total.add(tran.getAmount());
        }

        System.out.println("----------------------------------------");
        System.out.println(String.format("% 11.2f TOTAL", total));
        System.out.println();
        System.out.println("<<< Transaction list END");
    }

    private static void removeTransactionFromList(List<MoneyTransaction> transactions) {
        System.out.println();
        System.out.println("Remove transaction START >>>");
        System.out.println();

        System.out.print("Enter transaction id:");
        int transactionId = Integer.parseInt(new Scanner(System.in).nextLine());

        Optional<MoneyTransaction> transactionToRemove = transactions.stream()
                                        .filter(moneyTransaction -> moneyTransaction.getId() == transactionId)
                                        .findFirst();

        if (transactionToRemove.isPresent()) {
            transactions.remove(transactionToRemove.get());
            System.out.println(String.format("Transaction with Id %d removed from list", transactionId));
        } else {
            System.out.println(String.format("Transaction with Id %d not found in a list!", transactionId));
        }
    }

    private static void addTransactionToList(List<MoneyTransaction> transactions) {
        System.out.println();
        System.out.println("Add transaction START >>>");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction amount:");
        BigDecimal amount;
        try {
            amount = new BigDecimal(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println(String.format("Something was wrong: %s", e.getMessage()));
            return;
        }

        System.out.print("Enter transaction description:");
        String description = sc.nextLine();

        transactions.add(new MoneyTransaction(amount, description));

        System.out.println();
        System.out.println("<<< Add transaction END");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println(String.format("Something was wrong: %s", e.getMessage()));
            return -1;
        }
    }

    private static void printProgramMenu() {
        System.out.println();
        System.out.println("Program Menu:");
        System.out.println("1. Add transaction to list");
        System.out.println("2. Remove transaction from list");
        System.out.println("3. Print transaction list to console");
        System.out.println("4. Exit");
    }
}
