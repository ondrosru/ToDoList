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
        if (deals.size() != 0)
        {
            for (IDeal deal : deals )
            {
                System.out.println(deal.getDescription() + " | " + deal.getStatus().toString());
            }
        } else {
            System.out.println("Пустой список дел.");
        }

    }
}
