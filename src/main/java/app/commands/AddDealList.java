package app.commands;

import app.domains.list.IDealList;
import app.factories.DealListFactory;

import java.util.ArrayList;

public class AddDealList implements Command {
    private IDealList dealList;
    private ArrayList<IDealList> dealLists;

    public AddDealList(ArrayList<IDealList> dealLists, IDealList dealList) {
        this.dealLists = dealLists;
        this.dealList = dealList;
    }

    @Override
    public void execute() {
        dealLists.add(dealList);
    }
}
