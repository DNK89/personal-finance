package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.database.Database;
import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.math.BigDecimal;
import java.util.List;

public class FinanceFinanceTransactionListServiceImpl implements FinanceTransactionListService {
    private Database database;

    public FinanceFinanceTransactionListServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public FinanceTransactionListResponse getAllWithTotalSum() {
        List<FinanceTransaction> financeTransactions = database.getAllFinanceTransactions();

        BigDecimal totalSum = new BigDecimal(0);
        for (FinanceTransaction tran: financeTransactions) {
            totalSum = totalSum.add(tran.getAmount());
        }

        return new FinanceTransactionListResponse(financeTransactions, totalSum);
    }
}
