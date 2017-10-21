package lv.dnk89.personalfinance.businesslogic.api;

public class FinanceTransactionAddResponse {
    private final boolean successful;

    public FinanceTransactionAddResponse(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }
}
