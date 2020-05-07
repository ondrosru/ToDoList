package app.commands;

import app.domains.list.IDealList;

import java.util.ArrayList;

public class RemoveDealList implements Command {
    private IDealList dealList;
    private ArrayList<IDealList> dealLists;

    public RemoveDealList(ArrayList<IDealList> dealLists, IDealList dealList) {
        this.dealLists = dealLists;
        this.dealList = dealList;
    }

    @Override
    public void execute() {
        if(dealLists.contains(dealList))
        {
            dealLists.remove(dealList);
        }
    }
}
