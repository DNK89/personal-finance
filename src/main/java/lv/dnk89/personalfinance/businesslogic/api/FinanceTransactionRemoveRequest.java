package lv.dnk89.personalfinance.businesslogic.api;

public class FinanceTransactionRemoveRequest {

    private final int transactionId;

    public FinanceTransactionRemoveRequest(int transactionId) {
        this.transactionId = transactionId;
    }

    public int getTransactionId() {
        return transactionId;
    }
}
