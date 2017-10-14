import lv.dnk89.personalfinance.domain.FinanceTransaction;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class FinanceTransactionTest {

    @Test
    public void afterCreateIdIncreasesByOne() {
        for (int i = 1; i <= 5; i++)
            assertEquals(i, new FinanceTransaction(new BigDecimal(i), "").getId());
    }
}
