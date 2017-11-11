package lv.dnk89.personalfinance.businesslogic.api;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FinanceTransactionAddRequest {
    private final BigDecimal sum;
    private final String description;
    private final LocalDate date;

    public FinanceTransactionAddRequest(BigDecimal sum, String description, LocalDate date) {
        this.sum = sum;
        this.description = description;
        this.date = date;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }
}
