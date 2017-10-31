package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionListService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionListResponse;
import lv.dnk89.personalfinance.database.FinanceTransactionDAO;

public class FinanceTransactionListServiceImpl implements FinanceTransactionListService {
    private FinanceTransactionDAO financeTransactionDAO;

    public FinanceTransactionListServiceImpl(FinanceTransactionDAO financeTransactionDAO) {
        this.financeTransactionDAO = financeTransactionDAO;
    }

    @Override
    public FinanceTransactionListResponse getFinanceTransactions() {
        return new FinanceTransactionListResponse(financeTransactionDAO.getAll());
    }
}
