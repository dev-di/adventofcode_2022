package advent.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainStrategy1 {
    Main main = new Main();
    Strategy strategy;

    @BeforeEach
    public void setUp() {
        main = new Main();
        strategy = new Strategy1();
    }

    @ParameterizedTest
    @CsvSource(value = {"A Y:8", "B X:1", "C Z:6"}, delimiter = ':')
    public void testRowPointStrategy(String input, int expected) {
        int points = strategy.getPoints(input);
        assertEquals(expected, points);
    }

    @Test
    public void testSumPoints() {
        int points = main.getStrategySum(Main.exampleFile, strategy);
        assertEquals(15, points);
    }

}