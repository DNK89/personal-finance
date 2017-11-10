package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionListService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionListResponse;
import lv.dnk89.personalfinance.database.FinanceTransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FinanceTransactionListServiceImpl implements FinanceTransactionListService {

    private FinanceTransactionDAO financeTransactionDAO;

    @Autowired
    public FinanceTransactionListServiceImpl(FinanceTransactionDAO financeTransactionDAO) {
        this.financeTransactionDAO = financeTransactionDAO;
    }

    @Override
    public FinanceTransactionListResponse getFinanceTransactions() {
        return new FinanceTransactionListResponse(financeTransactionDAO.getAll());
    }
}
