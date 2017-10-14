package lv.dnk89.personalfinance.database;

import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryDatabase implements Database {

    private List<FinanceTransaction> financeTransactions = new ArrayList<>();

    @Override
    public void saveFinanceTransaction(FinanceTransaction financeTransaction) {
        financeTransactions.add(financeTransaction);
    }

    @Override
    public boolean removeFinanceTransactionById(Integer id) {
        Optional<FinanceTransaction> transactionToRemove = financeTransactions.stream()
                .filter(moneyTransaction -> moneyTransaction.getId() == id)
                .findFirst();

        if (transactionToRemove.isPresent()) {
            financeTransactions.remove(transactionToRemove.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<FinanceTransaction> getAllFinanceTransactions() {
        List<FinanceTransaction> cloned = new ArrayList<>();
        cloned.addAll(financeTransactions);
        return cloned;
    }
}
