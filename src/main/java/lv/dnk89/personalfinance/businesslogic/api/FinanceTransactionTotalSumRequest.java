package lv.dnk89.personalfinance.businesslogic.api;

import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.util.ArrayList;
import java.util.List;

public class FinanceTransactionTotalSumRequest {

    private final List<FinanceTransaction> transactions;

    public FinanceTransactionTotalSumRequest(List<FinanceTransaction> transactions) {
        this.transactions = transactions;
    }

    public List<FinanceTransaction> getTransactions() {
        List<FinanceTransaction> mutableCopy = new ArrayList<>();
        mutableCopy.addAll(transactions);
        return mutableCopy;
    }

}
