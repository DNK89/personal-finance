package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.database.Database;
import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.math.BigDecimal;

public class FinanceFinanceTransactionAddServiceImpl implements FinanceTransactionAddService {
    private Database database;

    public FinanceFinanceTransactionAddServiceImpl(Database database) {
        this.database = database;
    }

    @Override
    public void addTransaction(BigDecimal amount, String description) {
        FinanceTransaction financeTransaction = new FinanceTransaction(amount, description);
        database.saveFinanceTransaction(financeTransaction);
    }
}
