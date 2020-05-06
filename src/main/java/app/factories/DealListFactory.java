package app.factories;

import app.domains.deal.IDeal;
import app.domains.list.DealList;
import app.domains.list.IDealList;

import java.util.ArrayList;

public class DealListFactory {
    public static IDealList create(String name) {
        return new DealList(name);
    }
}
