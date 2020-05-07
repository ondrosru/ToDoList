package app.domains;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;
import app.factories.DealFactory;
import app.factories.DealListFactory;
import org.junit.jupiter.api.Test;

public class DealListTests {
    @Test
    public void testCreateDealList() {
        String name = "some name";
        IDealList dealList = DealListFactory.create(name);
        assert(dealList.getName().equals(name));
        assert(dealList.getDeals().size() == 0);
    }

    @Test
    public void testSetName_DealList() {
        String name = "some name";
        String newName = "some name 2";
        IDealList dealList = DealListFactory.create(name);
        dealList.setName(newName);
        assert(dealList.getName().equals(newName));
        assert(dealList.getDeals().size() == 0);
    }

    @Test
    public void testAddDeal_DealList() {
        String name = "some name";
        String description = "some description";
        IDealList dealList = DealListFactory.create(name);
        IDeal deal = DealFactory.create(description);
        dealList.addDeal(deal);
        assert(dealList.getDeals().size() == 1);
    }

    @Test
    public void testAddDeals_DealList() {
        String name = "some name";
        String description = "some description";
        IDealList dealList = DealListFactory.create(name);
        IDeal deal = DealFactory.create(description);
        dealList.addDeal(deal);
        dealList.addDeal(deal);
        assert(dealList.getDeals().size() == 2);
    }

    @Test
    public void testRemoveDeal_DealList() {
        String name = "some name";
        String description = "some description";
        IDealList dealList = DealListFactory.create(name);
        IDeal deal = DealFactory.create(description);
        dealList.addDeal(deal);
        dealList.removeDeal(deal);
        assert(dealList.getDeals().size() == 0);
    }
}
