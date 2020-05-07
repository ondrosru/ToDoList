package app.commands;

import app.domains.deal.IDeal;
import app.domains.list.IDealList;
import app.factories.DealFactory;
import app.factories.DealListFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTests {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testViewDeals() throws Exception {
        System.out.println("view");
        String description =  "description deal";
        IDealList dealList = DealListFactory.create("name list");
        IDeal deal = DealFactory.create(description);
        dealList.addDeal(deal);
        Command viewDeal = new ViewDeals(dealList);
        viewDeal.execute();
        assertEquals("view\r\n"
                    +"InProgress | description deal\r\n", outContent.toString());
    }
}
