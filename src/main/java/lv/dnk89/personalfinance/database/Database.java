package lv.dnk89.personalfinance.database;

import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.util.List;

public interface Database {

    void saveFinanceTransaction(FinanceTransaction financeTransaction);

    boolean removeFinanceTransactionById(Integer id);

    List<FinanceTransaction> getAllFinanceTransactions();
}
