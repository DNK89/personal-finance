package lv.dnk89.personalfinance.domain;

import java.math.BigDecimal;

public class FinanceTransaction {
    final private int id;
    final private BigDecimal sum;
    final private String description;

    private static int nextId = 1;

    public FinanceTransaction(BigDecimal sum, String description) {
        this.id = nextId++;
        this.sum = sum;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (o.getClass() != getClass()))
            return false;

        FinanceTransaction t = (FinanceTransaction) o;
        return this.getId() == t.getId();
    }

    @Override
    public String toString() {
        return String.format("FinanceTransaction{id=%s,sum=%s,description=%s}", id, getSum(), getDescription());
    }

}
