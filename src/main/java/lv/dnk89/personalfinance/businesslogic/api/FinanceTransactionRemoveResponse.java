package lv.dnk89.personalfinance.businesslogic.api;

public class FinanceTransactionRemoveResponse {

    private boolean successful;

    public FinanceTransactionRemoveResponse(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
