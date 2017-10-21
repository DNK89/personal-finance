package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionListService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionListResponse;
import lv.dnk89.personalfinance.database.Database;
import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.util.List;

public class FinanceTransactionListServiceImpl implements FinanceTransactionListService {
    private Database database;

    public FinanceTransactionListServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public FinanceTransactionListResponse getFinanceTransactions() {
        List<FinanceTransaction> financeTransactions = database.getAllFinanceTransactions();
        return new FinanceTransactionListResponse(financeTransactions);
    }
}
