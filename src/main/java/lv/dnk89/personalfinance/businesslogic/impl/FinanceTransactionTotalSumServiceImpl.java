package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionTotalSumService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionTotalSumRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionTotalSumResponse;
import lv.dnk89.personalfinance.domain.FinanceTransaction;

import java.math.BigDecimal;

public class FinanceTransactionTotalSumServiceImpl implements FinanceTransactionTotalSumService {

    @Override
    public FinanceTransactionTotalSumResponse getTotalSum(FinanceTransactionTotalSumRequest request) {
        BigDecimal totalSum = new BigDecimal(0);
        for (FinanceTransaction tran: request.getTransactions()) {
            totalSum = totalSum.add(tran.getSum());
        }
        return new FinanceTransactionTotalSumResponse(totalSum);
    }

}
