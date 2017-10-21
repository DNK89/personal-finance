package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionAddService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddResponse;
import lv.dnk89.personalfinance.database.Database;
import lv.dnk89.personalfinance.domain.FinanceTransaction;

public class FinanceTransactionAddServiceImpl implements FinanceTransactionAddService {
    private Database database;

    public FinanceTransactionAddServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public FinanceTransactionAddResponse addTransaction(FinanceTransactionAddRequest request) {
        FinanceTransaction financeTransaction = new FinanceTransaction(request.getSum(), request.getDescription());
        database.saveFinanceTransaction(financeTransaction);
        return new FinanceTransactionAddResponse(true);
    }
}
