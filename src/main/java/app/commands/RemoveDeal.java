package app.commands;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;

public class RemoveDeal implements Command {
    private IDeal deal;
    private IDealList dealList;

    public RemoveDeal(IDealList dealList, IDeal deal) {
        this.deal = deal;
        this.dealList = dealList;
    }

    @Override
    public void execute() {
        if(dealList.getDeals().contains(deal))
        {
            this.dealList.removeDeal(deal);
        }
    }
}
