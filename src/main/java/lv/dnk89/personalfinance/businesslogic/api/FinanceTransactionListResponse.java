package lv.dnk89.personalfinance.businesslogic.api;

import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.util.ArrayList;
import java.util.List;

public class FinanceTransactionListResponse {

    private final List<FinanceTransaction> financeTransactions;

    public FinanceTransactionListResponse(List<FinanceTransaction> financeTransactions) {
        this.financeTransactions = financeTransactions;
    }

    public List<FinanceTransaction> getFinanceTransactions() {
        List<FinanceTransaction> mutableCopy = new ArrayList<>();
        mutableCopy.addAll(financeTransactions);
        return mutableCopy;
    }

}
