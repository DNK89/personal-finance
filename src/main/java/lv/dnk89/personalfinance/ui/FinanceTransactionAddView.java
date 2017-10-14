package lv.dnk89.personalfinance.ui;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionAddService;

import java.math.BigDecimal;
import java.util.Scanner;

public class FinanceTransactionAddView implements View {

    private FinanceTransactionAddService financeTransactionAddService;

    public FinanceTransactionAddView(FinanceTransactionAddService financeTransactionAddService) {
        this.financeTransactionAddService = financeTransactionAddService;
    }

    @Override
    public void execute() {
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

        financeTransactionAddService.addTransaction(amount, description);

        System.out.println();
        System.out.println("<<< Add transaction END");
    }
}
