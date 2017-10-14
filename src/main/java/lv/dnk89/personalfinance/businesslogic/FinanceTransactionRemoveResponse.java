package lv.dnk89.personalfinance.businesslogic;

public class FinanceTransactionRemoveResponse {

    private boolean successful;

    FinanceTransactionRemoveResponse(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
