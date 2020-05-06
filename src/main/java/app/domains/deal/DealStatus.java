package app.domains.deal;

public enum DealStatus {
    InProgress("InProgress"),
    Complete("Complete"),
    Canceled("Canceled");

    private String status;
    private DealStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status;
    }
}
