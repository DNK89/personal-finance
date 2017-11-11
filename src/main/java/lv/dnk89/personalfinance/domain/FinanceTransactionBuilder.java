package lv.dnk89.personalfinance.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FinanceTransactionBuilder {

    private Long id;
    private LocalDate date;
    private BigDecimal sum;
    private String description;

    private FinanceTransactionBuilder() {
        date = LocalDate.now();
    }

    public static FinanceTransactionBuilder createFinanceTransaction() {
        return new FinanceTransactionBuilder();
    }

    public FinanceTransaction build() {
        FinanceTransaction transaction = new FinanceTransaction();
        transaction.setId(id);
        transaction.setDate(date);
        transaction.setSum(sum);
        transaction.setDescription(description);
        return transaction;
    }

    public FinanceTransactionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FinanceTransactionBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public FinanceTransactionBuilder withSum(BigDecimal sum) {
        this.sum = sum;
        return this;
    }

    public FinanceTransactionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
}
