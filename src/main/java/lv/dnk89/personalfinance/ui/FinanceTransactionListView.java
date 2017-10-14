package lv.dnk89.personalfinance.ui;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionListResponse;
import lv.dnk89.personalfinance.businesslogic.FinanceTransactionListService;
import lv.dnk89.personalfinance.domain.FinanceTransaction;

public class FinanceTransactionListView implements View {
    private FinanceTransactionListService financeTransactionListService;

    public FinanceTransactionListView(FinanceTransactionListService financeTransactionListService) {
        this.financeTransactionListService = financeTransactionListService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("FinanceTransaction list START >>>");
        System.out.println();

        FinanceTransactionListResponse response = financeTransactionListService.getAllWithTotalSum();

        for (FinanceTransaction tran: response.getFinanceTransactions()) {
            System.out.println(String.format("%2d) %7.2f %-25s", tran.getId(), tran.getAmount(), tran.getDescription()));
        }

        System.out.println("----------------------------------------");
        System.out.println(String.format("% 11.2f TOTAL", response.getTotal()));
        System.out.println();
        System.out.println("<<< FinanceTransaction list END");
    }
}
