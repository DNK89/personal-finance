package lv.dnk89.personalfinance.ui;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionTotalSumService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionListResponse;
import lv.dnk89.personalfinance.businesslogic.FinanceTransactionListService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionTotalSumRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionTotalSumResponse;
import lv.dnk89.personalfinance.domain.FinanceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class FinanceTransactionListView implements View {

    private FinanceTransactionListService financeTransactionListService;

    private FinanceTransactionTotalSumService financeTransactionTotalSumService;

    @Autowired
    public FinanceTransactionListView(FinanceTransactionListService financeTransactionListService, FinanceTransactionTotalSumService financeTransactionTotalSumService) {
        this.financeTransactionListService = financeTransactionListService;
        this.financeTransactionTotalSumService = financeTransactionTotalSumService;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("FinanceTransaction list START >>>");
        System.out.println();

        FinanceTransactionListResponse listResponse = financeTransactionListService.getFinanceTransactions();

        for (FinanceTransaction tran: listResponse.getFinanceTransactions()) {
            System.out.println(String.format("%2d) %7.2f %-25s %s", tran.getId(), tran.getSum(), tran.getDescription(),
                    tran.getDate().format(DateTimeFormatter.ISO_LOCAL_DATE)));
        }

        FinanceTransactionTotalSumRequest totalSumRequest = new FinanceTransactionTotalSumRequest(listResponse.getFinanceTransactions());
        FinanceTransactionTotalSumResponse totalSumResponse = financeTransactionTotalSumService.getTotalSum(totalSumRequest);

        System.out.println("------------------------------------------------");
        System.out.println(String.format("% 11.2f TOTAL", totalSumResponse.getTotalSum()));
        System.out.println();
        System.out.println("<<< FinanceTransaction list END");
    }
}
