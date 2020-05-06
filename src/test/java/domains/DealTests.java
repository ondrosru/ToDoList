package domains;

import app.domains.deal.DealStatus;
import app.domains.deal.IDeal;
import app.factories.DealFactory;
import org.junit.jupiter.api.Test;

public class DealTests {
    @Test
    public void testCreateDealWithOneArgument() {
        String description = "some description";
        IDeal deal = DealFactory.create(description);
        assert(description.equals(deal.getDescription()));
        assert(DealStatus.InProgress == deal.getStatus());
    }

    @Test
    public void testCreateDealWithTwoArguments() {
        String description = "some description";
        IDeal deal = DealFactory.create(description, DealStatus.Complete);
        assert(description.equals(deal.getDescription()));
        assert(DealStatus.Complete == deal.getStatus());
    }

    @Test
    public void testSetStatus() {
        String description = "some description";
        IDeal deal = DealFactory.create(description);
        deal.setStatus(DealStatus.Complete);
        assert(description.equals(deal.getDescription()));
        assert(DealStatus.Complete == deal.getStatus());
    }

    @Test
    public void testSetDescription() {
        String description = "some description";
        String newDescription = "new description";
        IDeal deal = DealFactory.create(description);
        deal.setDescription(newDescription);
        assert(newDescription.equals(deal.getDescription()));
        assert(DealStatus.InProgress == deal.getStatus());
    }
}
