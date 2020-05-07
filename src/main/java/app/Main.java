package app;

import app.domains.list.IDealList;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        String pathFile;
        if (args.length == 1) {
            pathFile = args[0];
        } else {
            pathFile = "./src/data.json";
        }

        JsonReader jsonReader = new JsonReader();
        ArrayList<IDealList> dealLists = jsonReader.readDealLists(pathFile);
        Menu menu = new Menu(dealLists);
        menu.start();
        dealLists = menu.getDealLists();
        JsonWriter jsonWriter = new JsonWriter();
        jsonWriter.writeDealLists(dealLists, pathFile);
    }
}
