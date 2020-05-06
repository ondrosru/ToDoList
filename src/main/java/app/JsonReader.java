package app;

import app.domains.deal.DealStatus;
import app.domains.list.IDealList;
import app.factories.DealFactory;
import app.factories.DealListFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class JsonReader {
    public JsonReader() {
    }

    public ArrayList<IDealList> readDealLists(String fileName) {
        ArrayList<IDealList> dealLists = new ArrayList<IDealList>();
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader(fileName);
            Object obj = parser.parse(reader);
            JSONObject dealListsObject = (JSONObject) obj;
            JSONArray dealListsArray = (JSONArray) dealListsObject.get("Lists");
            Iterator<JSONObject> iterator = dealListsArray.iterator();
            while (iterator.hasNext())
            {
                JSONObject dealListObject = iterator.next();
                String dealListName = dealListObject.get("Name").toString();
                IDealList dealList = DealListFactory.create(dealListName);
                JSONArray dealListArray = (JSONArray) dealListObject.get("Deals");
                Iterator<JSONObject> dealsIterator = dealListArray.iterator();
                while (dealsIterator.hasNext())
                {
                    JSONObject dealObject = dealsIterator.next();
                    String description = dealObject.get("Description").toString();
                    DealStatus status = DealStatus.valueOf(dealObject.get("Status").toString());
                    dealList.addDeal(DealFactory.create(description, status));
                }
                dealLists.add(dealList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dealLists;
    }
}
