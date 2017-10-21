package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionListResponse;

public interface FinanceTransactionListService {

    FinanceTransactionListResponse getFinanceTransactions();

}
