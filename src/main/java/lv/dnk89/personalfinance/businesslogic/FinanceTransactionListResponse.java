package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.math.BigDecimal;
import java.util.List;

public class FinanceTransactionListResponse {

    private List<FinanceTransaction> financeTransactions;
    private BigDecimal total;

    FinanceTransactionListResponse(List<FinanceTransaction> financeTransactions, BigDecimal total) {
        this.financeTransactions = financeTransactions;
        this.total = total;
    }

    public List<FinanceTransaction> getFinanceTransactions() {
        return financeTransactions;
    }

    public BigDecimal getTotal() {
        return total;
    }

}
