package app.commands;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;

import java.util.ArrayList;

public class AddDeal implements Command {
    IDeal deal;
    IDealList dealList;

    public  AddDeal(IDealList dealList, IDeal deal) {
        this.dealList = dealList;
        this.deal = deal;
    }

    @Override
    public void execute() {
        this.dealList.addDeal(deal);
    }
}
