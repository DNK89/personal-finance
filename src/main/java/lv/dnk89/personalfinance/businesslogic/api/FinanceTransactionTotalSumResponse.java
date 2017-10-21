package lv.dnk89.personalfinance.businesslogic.api;

import java.math.BigDecimal;

public class FinanceTransactionTotalSumResponse {

    private final BigDecimal totalSum;

    public FinanceTransactionTotalSumResponse(BigDecimal totalSum) {
        this.totalSum = totalSum;
    }

    public BigDecimal getTotalSum() {
        return totalSum;
    }

}
