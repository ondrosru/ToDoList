package app.commands;

import app.domains.list.IDealList;
import app.factories.DealListFactory;

import java.util.ArrayList;

public class AddDealList implements Command {
    private String name;
    private ArrayList<IDealList> dealLists;

    public AddDealList(ArrayList<IDealList> dealLists, String name) {
        this.dealLists = dealLists;
        this.name = name;
    }

    @Override
    public void execute() {
        dealLists.add(DealListFactory.create(this.name));
    }
}
