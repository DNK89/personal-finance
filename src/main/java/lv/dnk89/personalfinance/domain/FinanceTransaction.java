package lv.dnk89.personalfinance.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FinanceTransaction {

    private Long id;
    private LocalDate date;
    private BigDecimal sum;
    private String description;

    public FinanceTransaction() {
        date = LocalDate.now();
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
