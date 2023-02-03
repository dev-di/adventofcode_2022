package advent.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static advent.day02.Selection.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelectionTest {
    Main main;

    @BeforeEach
    public void setUp() {
        main = new Main();
    }

    @Test
    public void testWinsOver() {
        assertTrue(ROCK.winsOver(SCISSORS), "Expected ROCK to win over SCISSORS");
        assertTrue(SCISSORS.winsOver(PAPER), "Expected SCISSORS to win over PAPER");
        assertTrue(PAPER.winsOver(ROCK), "Expected PAPER to win over ROCK");

        assertFalse(ROCK.winsOver(ROCK), "Expected draw");
        assertFalse(SCISSORS.winsOver(SCISSORS), "Expected draw");
        assertFalse(PAPER.winsOver(PAPER), "Expected draw");

        assertFalse(ROCK.winsOver(PAPER), "Expected loss");
        assertFalse(SCISSORS.winsOver(ROCK), "Expected loss");
        assertFalse(PAPER.winsOver(SCISSORS), "Expected loss");
    }

}