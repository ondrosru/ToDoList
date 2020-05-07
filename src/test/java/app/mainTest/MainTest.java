package app.mainTest;

import app.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() throws FileNotFoundException {
        File file = new File("./src/test/java/app/mainTest/input.json");
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        writer.close();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = {"./src/test/java/app/mainTest/input.json"};
        String trueOutput =  readAllBytes("./src/test/java/app/mainTest/TrueOutput.txt");
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("./src/test/java/app/mainTest/ConsoleInput.txt"));
        System.setIn(fips);
        Main.main(args);
        System.setIn(original);
        assertEquals(trueOutput, outContent.toString());
    }

    private static String readAllBytes(String filePath)
    {
        String content = "";
        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
