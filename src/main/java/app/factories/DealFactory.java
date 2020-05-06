package app.factories;

import app.domains.deal.Deal;
import app.domains.deal.DealStatus;
import app.domains.deal.IDeal;

public class DealFactory {
    public static IDeal create(String description) {
        return new Deal(description);
    }

    public static IDeal create(String description, DealStatus status) {
        return new Deal(description, status);
    }
}
