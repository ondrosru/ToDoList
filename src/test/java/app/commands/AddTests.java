package app.commands;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;
import app.factories.DealFactory;
import app.factories.DealListFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;

public class AddTests {

    @Test
    public void testAddDeal() {
        String description =  "description deal";
        IDealList dealList = DealListFactory.create("name list");
        IDeal deal = DealFactory.create(description);
        Command addCommand = new AddDeal(dealList, deal);
        addCommand.execute();
        assertEquals(dealList.getDeals().size(), 1);
    }

    @Test
    public void testAddDealList() {
        String listName = "Name";
        IDealList dealList = DealListFactory.create(listName);
        ArrayList<IDealList> dealLists = new ArrayList<IDealList>();
        Command addCommand = new AddDealList(dealLists, dealList);
        addCommand.execute();
        assertEquals(dealLists.size(), 1);
    }
}
