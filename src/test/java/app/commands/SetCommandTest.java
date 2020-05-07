package app.commands;

import app.domains.deal.DealStatus;
import app.domains.deal.IDeal;
import app.factories.DealFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SetCommandTest {
    @Test
    public void testSetStatus() {
        String description =  "description deal";
        IDeal deal = DealFactory.create(description);
        Command changeStatusCommand = new ChangeStatus(deal, DealStatus.Complete);
        changeStatusCommand.execute();
        assertEquals(deal.getStatus(), DealStatus.Complete);
    }

    @Test
    public void testChangeDescription() {
        String description =  "description deal";
        String newDescription =  "new";
        IDeal deal = DealFactory.create(description);
        Command changeDescriptionCommand = new ChangeDescription(deal, newDescription);
        changeDescriptionCommand.execute();
        assertEquals(deal.getDescription(), newDescription);
    }
}
