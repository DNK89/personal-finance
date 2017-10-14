package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.database.Database;

public class FinanceFinanceTransactionRemoveServiceImpl implements FinanceTransactionRemoveService {
    private Database database;

    public FinanceFinanceTransactionRemoveServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public FinanceTransactionRemoveResponse removeBy(Integer id) {
        boolean success = database.removeFinanceTransactionById(id);
        return new FinanceTransactionRemoveResponse(success);
    }
}
