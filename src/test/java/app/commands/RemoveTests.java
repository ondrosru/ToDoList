package app.commands;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;
import app.factories.DealFactory;
import app.factories.DealListFactory;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemoveTests {

    @Test
    public void testRemoveDeal() {
        String description =  "description deal";
        IDealList dealList = DealListFactory.create("name list");
        IDeal deal = DealFactory.create(description);
        dealList.addDeal(deal);
        Command removeCommand = new RemoveDeal(dealList, deal);
        removeCommand.execute();
        assertEquals(dealList.getDeals().size(), 0);
    }

    @Test
    public void testRemoveDeal_fail() {
        String description =  "description deal";
        IDealList dealList = DealListFactory.create("name list");
        IDeal deal = DealFactory.create(description);
        Command removeCommand = new RemoveDeal(dealList, deal);
        removeCommand.execute();
        assertEquals(dealList.getDeals().size(), 0);
    }

    @Test
    public void testRemoveDealList() {
        String listName = "Name";
        IDealList dealList = DealListFactory.create(listName);
        ArrayList<IDealList> dealLists = new ArrayList<IDealList>();
        dealLists.add(dealList);
        Command removeCommand = new RemoveDealList(dealLists, dealList);
        removeCommand.execute();
        assertEquals(dealLists.size(), 0);
    }

    @Test
    public void testRemoveDealList_fail() {
        String listName = "Name";
        IDealList dealList = DealListFactory.create(listName);
        ArrayList<IDealList> dealLists = new ArrayList<IDealList>();
        Command removeCommand = new RemoveDealList(dealLists, dealList);
        removeCommand.execute();
        assertEquals(dealLists.size(), 0);
    }
}
