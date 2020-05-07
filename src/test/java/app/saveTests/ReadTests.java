package app.saveTests;

import app.JsonReader;
import app.domains.list.IDealList;
import app.factories.DealFactory;
import app.factories.DealListFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadTests {

    @Test
    public void testRead(){
        JsonReader reader = new JsonReader();
        ArrayList<IDealList> dealLists;
        dealLists = reader.readDealLists("./src/test/java/app/saveTests/input.json");
        ArrayList<IDealList> dealListsTrue = new ArrayList<IDealList>();
        IDealList dealList = DealListFactory.create("Список-1");
        dealList.addDeal(DealFactory.create("Дело-1"));
        dealList.addDeal(DealFactory.create("Дело-2"));
        dealListsTrue.add(dealList);
        assertEquals(dealListsTrue.size(), dealLists.size());
        assertEquals(dealListsTrue.get(0).getDeals().size(), dealLists.get(0).getDeals().size());
    }
}
