package lv.dnk89.personalfinance.businesslogic;

import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveResponse;

public interface FinanceTransactionRemoveService {

    FinanceTransactionRemoveResponse removeById(FinanceTransactionRemoveRequest request);
}
