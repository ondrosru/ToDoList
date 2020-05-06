package app.domains.deal;

public interface IDeal {
    String getDescription();
    void setDescription(String description);
    DealStatus getStatus();
    void setStatus(DealStatus status);
    String toString();
}
