package app.commands;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;

import java.util.ArrayList;

public class ViewDeals implements Command {
    IDealList dealList;

    public  ViewDeals(IDealList dealList ) {
        this.dealList = dealList;
    }

    @Override
    public void execute() {

        ArrayList<IDeal> deals = this.dealList.getDeals();
        for (IDeal deal : deals )
        {
            System.out.println(deal.getStatus().toString() + " | " + deal.getDescription());
        }
        if (deals.size() == 0) {
            System.out.println("Дел нет.");
        }
    }
}
