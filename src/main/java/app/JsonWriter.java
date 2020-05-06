package app;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.management.Descriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JsonWriter {
    public JsonWriter() {
    }

    public void writeDealLists(ArrayList<IDealList> dealLists, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            JSONObject dealListsObj = new JSONObject();
            JSONArray dealListsArray = new JSONArray();
            for (IDealList dealList : dealLists) {
                JSONObject dealListObj = new JSONObject();
                dealListObj.put("Name", dealList.getName());
                JSONArray dealsArray = new JSONArray();
                for (IDeal deal: dealList.getDeals()) {
                    JSONObject dealObj = new JSONObject();
                    dealObj.put("Description", deal.getDescription());
                    dealObj.put("Status", deal.getStatus().toString());
                    dealsArray.add(dealObj);
                }
                dealListObj.put("Deals", dealsArray);
                dealListsArray.add(dealListObj);
            }
            dealListsObj.put("Lists", dealListsArray);
            writer.write(dealListsObj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
