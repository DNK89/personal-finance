package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionAddService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddResponse;
import lv.dnk89.personalfinance.database.FinanceTransactionDAO;
import lv.dnk89.personalfinance.domain.FinanceTransaction;

public class FinanceTransactionAddServiceImpl implements FinanceTransactionAddService {
    private FinanceTransactionDAO financeTransactionDAO;

    public FinanceTransactionAddServiceImpl(FinanceTransactionDAO financeTransactionDAO) {
        this.financeTransactionDAO = financeTransactionDAO;
    }

    @Override
    public FinanceTransactionAddResponse addTransaction(FinanceTransactionAddRequest request) {
        FinanceTransaction financeTransaction = new FinanceTransaction(request.getSum(), request.getDescription());
        financeTransactionDAO.save(financeTransaction);
        return new FinanceTransactionAddResponse(true);
    }
}
