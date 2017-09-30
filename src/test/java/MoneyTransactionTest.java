import lv.dnk89.personalfinance.MoneyTransaction;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

public class MoneyTransactionTest {

    @Test
    public void afterCreateIdIncreasesByOne() {
        for (int i = 1; i <= 5; i++)
            assertEquals(i, new MoneyTransaction(new BigDecimal(i), "").getId());
    }
}
