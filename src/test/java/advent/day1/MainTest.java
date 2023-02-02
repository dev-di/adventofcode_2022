package advent.day1;

import junit.framework.TestCase;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTest extends TestCase {
    Main main = new Main();
    String file = "src/main/resources/day1/example_input.txt";

    @Test
    public void testGetMaxInventory() throws URISyntaxException, IOException {
        Integer maxInventory = main.getMaxInventory(file);

        assertEquals(24000, maxInventory.intValue());
    }

    @Test
    public void testGetSumOf3Greatest() throws URISyntaxException, IOException {
        Integer threeGreatestInventories = main.getGreatestSum(3, file);

        assertEquals(45000, threeGreatestInventories.intValue());
    }

}