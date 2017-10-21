package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveResponse;
import lv.dnk89.personalfinance.businesslogic.FinanceTransactionRemoveService;
import lv.dnk89.personalfinance.database.Database;

public class FinanceTransactionRemoveServiceImpl implements FinanceTransactionRemoveService {
    private Database database;

    public FinanceTransactionRemoveServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public FinanceTransactionRemoveResponse removeById(FinanceTransactionRemoveRequest request) {
        boolean success = database.removeFinanceTransactionById(request.getTransactionId());
        return new FinanceTransactionRemoveResponse(success);
    }
}
