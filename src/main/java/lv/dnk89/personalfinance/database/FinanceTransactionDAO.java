package lv.dnk89.personalfinance.database;

import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.util.List;
import java.util.Optional;

public interface FinanceTransactionDAO {

    FinanceTransaction save(FinanceTransaction transaction);

    Optional<FinanceTransaction> getById(Long id);

    void delete(FinanceTransaction transaction);

    List<FinanceTransaction> getAll();

}
