package advent.day01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    Main main = new Main();

    @Test
    public void testGetMaxInventory() {
        Integer maxInventory = main.getGreatestSum(1, Main.exampleFile);
        assertEquals(24000, maxInventory.intValue());
    }

    @Test
    public void testGetSumOf3Greatest() {
        Integer threeGreatestInventories = main.getGreatestSum(3, Main.exampleFile);
        assertEquals(45000, threeGreatestInventories.intValue());
    }

}