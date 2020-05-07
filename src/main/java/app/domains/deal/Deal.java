package app.domains.deal;

public class Deal implements IDeal {
    private String description;
    private DealStatus status;

    public Deal(String description)
    {
        this.description = description;
        this.status = DealStatus.InProgress;
    }

    public Deal(String description, DealStatus status)
    {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DealStatus getStatus() {
        return status;
    }

    public void setStatus(DealStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return status.toString() + " | " + description;
    }
}
