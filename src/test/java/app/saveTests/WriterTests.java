package app.saveTests;

import app.JsonWriter;
import app.domains.list.IDealList;
import app.factories.DealFactory;
import app.factories.DealListFactory;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WriterTests {
    @Test
    public void testWrite() throws IOException {
        JsonWriter writer = new JsonWriter();
        ArrayList<IDealList> dealLists = new ArrayList<IDealList>();
        IDealList dealList = DealListFactory.create("Список-1");
        dealList.addDeal(DealFactory.create("Дело-1"));
        dealList.addDeal(DealFactory.create("Дело-2"));
        dealLists.add(dealList);
        writer.writeDealLists(dealLists,"./src/test/java/app/saveTests/output.json");
        BufferedReader expected = new BufferedReader(new FileReader("./src/test/java/app/saveTests/trueOutput.json"));
        BufferedReader actual = new BufferedReader(new FileReader("./src/test/java/app/saveTests/output.json"));
        assertReaders(expected, actual);
    }

    public static void assertReaders(BufferedReader expected,
                                     BufferedReader actual) throws IOException {
        String line;
        while ((line = expected.readLine()) != null) {
            assertEquals(line, actual.readLine());
        }
    }
}
