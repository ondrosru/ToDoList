package app.domains.list;

import app.domains.deal.DealStatus;
import app.domains.deal.IDeal;

import java.util.ArrayList;

public interface IDealList {
    void addDeal(IDeal deal);
    void removeDeal(IDeal deal);
    ArrayList<IDeal> getDeals();
    String getName();
    void setName(String name);
}
