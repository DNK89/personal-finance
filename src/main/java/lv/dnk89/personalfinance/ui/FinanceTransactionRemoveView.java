package lv.dnk89.personalfinance.ui;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionRemoveService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class FinanceTransactionRemoveView implements View {

    private FinanceTransactionRemoveService financeTransactionRemoveService;

    @Autowired
    public FinanceTransactionRemoveView(FinanceTransactionRemoveService financeTransactionRemoveService) {
        this.financeTransactionRemoveService = financeTransactionRemoveService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove transaction START >>>");
        System.out.println();

        System.out.print("Enter transaction id:");
        int transactionId = Integer.parseInt(new Scanner(System.in).nextLine());

        FinanceTransactionRemoveRequest removeRequest = new FinanceTransactionRemoveRequest((long)transactionId);
        FinanceTransactionRemoveResponse removeResponse = financeTransactionRemoveService.removeById(removeRequest);

        if (removeResponse.isSuccessful()) {
            System.out.println(String.format("FinanceTransaction with Id %d removed from list", transactionId));
        } else {
            System.out.println(String.format("FinanceTransaction with Id %d not found in a list!", transactionId));
        }
    }
}