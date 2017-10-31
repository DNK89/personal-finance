package lv.dnk89.personalfinance.domain;

import java.math.BigDecimal;

public class FinanceTransactionBuilder {

    private Long id;
    private BigDecimal sum;
    private String description;

    private FinanceTransactionBuilder() {}

    public static FinanceTransactionBuilder createFinanceTransaction() {
        return new FinanceTransactionBuilder();
    }

    public FinanceTransaction build() {
        FinanceTransaction transaction = new FinanceTransaction();
        transaction.setId(id);
        transaction.setSum(sum);
        transaction.setDescription(description);
        return transaction;
    }

    public FinanceTransactionBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public FinanceTransactionBuilder withSum(BigDecimal amount) {
        this.sum = amount;
        return this;
    }

    public FinanceTransactionBuilder withDescription(String description) {
        this.description = description;
        return this;
    }
}
