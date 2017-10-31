package lv.dnk89.personalfinance.domain;

import java.math.BigDecimal;

public class FinanceTransaction {

    private Long id;
    private BigDecimal sum;
    private String description;

    public FinanceTransaction() {}

    public FinanceTransaction(BigDecimal sum, String description) {
        this.setSum(sum);
        this.setDescription(description);
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return String.format("FinanceTransaction{id=%s,sum=%s,description=%s}", getId(), getSum(), getDescription());
    }

}
