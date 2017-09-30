package lv.dnk89.personalfinance;

import java.math.BigDecimal;

public class MoneyTransaction {
    final private int id;
    final private BigDecimal amount;
    final private String description;

    private static int nextId = 1;

    public MoneyTransaction(BigDecimal amount, String description) {
        this.id = nextId++;
        this.amount = amount;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
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

        MoneyTransaction t = (MoneyTransaction) o;
        return this.getId() == t.getId();
    }

    @Override
    public String toString() {
        return String.format("MoneyTransaction{id=%s,amount=%s,description=%s}", id, getAmount(), getDescription());
    }

}
