package lv.dnk89.personalfinance.businesslogic.api;

public class FinanceTransactionRemoveRequest {

    private final Long transactionId;

    public FinanceTransactionRemoveRequest(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getTransactionId() {
        return transactionId;
    }
}
