package lv.dnk89.personalfinance.businesslogic.api;

import java.math.BigDecimal;

public class FinanceTransactionAddRequest {
    private final BigDecimal sum;
    private final String description;

    public FinanceTransactionAddRequest(BigDecimal sum, String description) {
        this.sum = sum;
        this.description = description;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public String getDescription() {
        return description;
    }
}
