package lv.dnk89.personalfinance.businesslogic.impl;

import lv.dnk89.personalfinance.businesslogic.FinanceTransactionRemoveService;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveRequest;
import lv.dnk89.personalfinance.businesslogic.api.FinanceTransactionRemoveResponse;
import lv.dnk89.personalfinance.database.FinanceTransactionDAO;
import lv.dnk89.personalfinance.domain.FinanceTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FinanceTransactionRemoveServiceImpl implements FinanceTransactionRemoveService {

    private FinanceTransactionDAO financeTransactionDAO;

    @Autowired
    public FinanceTransactionRemoveServiceImpl(FinanceTransactionDAO financeTransactionDAO) {
        this.financeTransactionDAO = financeTransactionDAO;
    }

    @Override
    public FinanceTransactionRemoveResponse removeById(FinanceTransactionRemoveRequest request) {
        Optional<FinanceTransaction> transactionOptional = financeTransactionDAO.getById(request.getTransactionId());
        if (transactionOptional.isPresent()) {
            FinanceTransaction transaction = transactionOptional.get();
            financeTransactionDAO.delete(transaction);
            return new FinanceTransactionRemoveResponse(true);
        } else {
            return new FinanceTransactionRemoveResponse(false);
        }
    }
}
