package advent.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMainStrategy2 {
    Main main = new Main();
    Strategy strategy;

    @BeforeEach
    public void setUp() {
        main = new Main();
        strategy = new Strategy2();
    }

    @ParameterizedTest
    @CsvSource(value = {"A Y:4", "B X:1", "C Z:7"}, delimiter = ':')
    public void testRowPointStrategy(String input, int expected) {
        int points = strategy.getPoints(input);
        assertEquals(expected, points);
    }

    @Test
    public void testSumPoints() {
        int points = main.getStrategySum(Main.exampleFile, strategy);
        assertEquals(12, points);
    }

}