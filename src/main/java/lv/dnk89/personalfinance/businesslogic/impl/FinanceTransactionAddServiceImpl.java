package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionAddService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionAddResponse;
import lv.dnk89.personalfinance.database.FinanceTransactionDAO;
import lv.dnk89.personalfinance.domain.FinanceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.dnk89.personalfinance.domain.FinanceTransactionBuilder.createFinanceTransaction;

@Component
public class FinanceTransactionAddServiceImpl implements FinanceTransactionAddService {

    private FinanceTransactionDAO financeTransactionDAO;

    @Autowired
    public FinanceTransactionAddServiceImpl(FinanceTransactionDAO financeTransactionDAO) {
        this.financeTransactionDAO = financeTransactionDAO;
    }

    @Override
    public FinanceTransactionAddResponse addTransaction(FinanceTransactionAddRequest request) {
        FinanceTransaction financeTransaction = createFinanceTransaction()
                .withSum(request.getSum())
                .withDate(request.getDate())
                .withDescription(request.getDescription()).build();
        financeTransactionDAO.save(financeTransaction);
        return new FinanceTransactionAddResponse(true);
    }
}
