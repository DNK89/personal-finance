package lv.dnk89.personalfinance.database.jdbc;

import lv.dnk89.personalfinance.database.DatabaseUtils;
import lv.dnk89.personalfinance.database.FinanceTransactionDAO;
import lv.dnk89.personalfinance.domain.FinanceTransaction;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static lv.dnk89.personalfinance.domain.FinanceTransactionBuilder.createFinanceTransaction;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FinanceTransactionDAOImplTest {

    private DatabaseUtils databaseUtils = new DatabaseUtils();
    private FinanceTransactionDAO transactionDAO = new FinanceTransactionDAOImpl();

    @Before
    public void init() {
        databaseUtils.cleanDatabase();
    }

    @Test
    public void testCreate() {
        FinanceTransaction transaction = create(BigDecimal.valueOf(100), "test");
        assertThat(transaction.getId(), is(notNullValue()));

        Optional<FinanceTransaction> transactionFromDB = transactionDAO.getById(transaction.getId());
        assertThat(transactionFromDB.isPresent(), is(true));
        assertEquals(transaction.getId(), transactionFromDB.get().getId());
        assertEquals(transaction.getSum().compareTo(transactionFromDB.get().getSum()), 0);
        assertEquals(transaction.getDescription(), transactionFromDB.get().getDescription());
        assertEquals(transaction.getDate(), transactionFromDB.get().getDate());
    }

    @Test
    public void testGetAll() {
        FinanceTransaction transaction1 = create(BigDecimal.valueOf(10), "ABC");
        FinanceTransaction transaction2 = create(BigDecimal.valueOf(20), "DEF");

        List<FinanceTransaction> transactions = transactionDAO.getAll();

        assertThat(transactions.size(), is(2));
        assertThat(transactions.contains(transaction1), is(true));
        assertThat(transactions.contains(transaction2), is(true));
    }

    @Test
    public void testDelete() {
        FinanceTransaction transaction1 = create(BigDecimal.valueOf(10), "ABC");
        FinanceTransaction transaction2 = create(BigDecimal.valueOf(20), "DEF");

        transactionDAO.delete(transaction1);
        List<FinanceTransaction> transactions = transactionDAO.getAll();

        assertThat(transactions.size(), is(1));
        assertThat(transactions.contains(transaction1), is(false));
        assertThat(transactions.contains(transaction2), is(true));

        transactionDAO.delete(transaction2);
        transactions = transactionDAO.getAll();

        assertThat(transactions.size(), is(0));
    }

    private FinanceTransaction create(BigDecimal sum, String description) {
        FinanceTransaction transaction = createFinanceTransaction()
                .withSum(sum)
                .withDescription(description)
                .build();
        return transactionDAO.save(transaction);
    }
}
