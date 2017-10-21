package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddResponse;

public interface FinanceTransactionAddService {

    FinanceTransactionAddResponse addTransaction(FinanceTransactionAddRequest request);
}
