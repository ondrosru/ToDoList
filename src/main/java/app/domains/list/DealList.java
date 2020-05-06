package app.domains.list;

import app.domains.deal.Deal;
import app.domains.deal.DealStatus;
import app.domains.deal.IDeal;

import java.util.ArrayList;

public class DealList implements IDealList {
    private ArrayList<IDeal> deals = new ArrayList<IDeal>();
    private String name;

    public DealList(String name) {
        this.name = name;
    }

    public void addDeal(IDeal deal) {
        this.deals.add(deal);
    }

    public void removeDeal(IDeal deal) {
        this.deals.remove(deal);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<IDeal> getDeals() {
        return this.deals;
    }
}
