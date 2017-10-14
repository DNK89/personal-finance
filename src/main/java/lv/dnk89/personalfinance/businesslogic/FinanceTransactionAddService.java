package lv.dnk89.personalfinance.businesslogic;

import java.math.BigDecimal;

public interface FinanceTransactionAddService {

    void addTransaction(BigDecimal amount, String description);
}
