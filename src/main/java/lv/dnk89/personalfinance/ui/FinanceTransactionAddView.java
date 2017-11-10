package lv.dnk89.personalfinance.ui;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionAddService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class FinanceTransactionAddView implements View {

    private FinanceTransactionAddService financeTransactionAddService;

    @Autowired
    public FinanceTransactionAddView(FinanceTransactionAddService financeTransactionAddService) {
        this.financeTransactionAddService = financeTransactionAddService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Add transaction START >>>");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction sum:");
        BigDecimal sum;
        try {
            sum = new BigDecimal(Double.parseDouble(sc.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println(String.format("Something was wrong: %s", e.getMessage()));
            return;
        }

        System.out.print("Enter transaction description:");
        String description = sc.nextLine();

        FinanceTransactionAddRequest addRequest = new FinanceTransactionAddRequest(sum, description);
        FinanceTransactionAddResponse addResponse = financeTransactionAddService.addTransaction(addRequest);

        if (addResponse.isSuccessful()) {
            System.out.println("Added successfully");
        } else {
            System.out.println("Adding failed!");
        }

        System.out.println();
        System.out.println("<<< Add transaction END");
    }
}
