package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionTotalSumRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionTotalSumResponse;

public interface FinanceTransactionTotalSumService {

    FinanceTransactionTotalSumResponse getTotalSum(FinanceTransactionTotalSumRequest request);
}
