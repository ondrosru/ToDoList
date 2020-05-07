package app.commands;

import app.domains.deal.DealStatus;
import app.domains.deal.IDeal;

public class ChangeStatus implements Command{
    private IDeal deal;
    private DealStatus status;

    public ChangeStatus(IDeal deal, DealStatus status) {
        this.deal = deal;
        this.status = status;
    }

    @Override
    public void execute() {
        deal.setStatus(status);
    }
}
