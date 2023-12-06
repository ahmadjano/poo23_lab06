package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JCalculatorTest {

    private State state;

    @BeforeEach
    void setUp() {
        state = new State();
    }

    @Test
    void additionDecimalTest() {
        new InsertNumber(state, 3).execute();
        new Decimal(state).execute();
        new InsertNumber(state, 5).execute();
        new Submit(state).execute();

        new InsertNumber(state, 4).execute();
        new Addition(state).execute();

        assertEquals("7.5", state.getCurrentValue());
    }

    @Test
    void subtractionOneInsertionTest() {
        new InsertNumber(state, 8).execute();
        new Submit(state).execute();
        new Subtraction(state).execute();

        assertEquals("8", state.getCurrentValue());
    }

    @Test
    void subtractionNegativeTest() {
        new InsertNumber(state, 2).execute();
        new Submit(state).execute();
        new InsertNumber(state, 5).execute();
        new Subtraction(state).execute();

        assertEquals("-3", state.getCurrentValue());
    }

    @Test
    void divisionDecimalTest() {
        // 7.5
        new InsertNumber(state, 7).execute();
        new Decimal(state).execute();
        new InsertNumber(state, 5).execute();

        new Submit(state).execute();

        // 3
        new InsertNumber(state, 3).execute();

        new Division(state).execute();

        assertEquals("2.5", state.getCurrentValue());
    }

    @Test
    void divisionZeroTest() {
        // 5
        new InsertNumber(state, 5).execute();

        new Submit(state).execute();

        // 0
        new InsertNumber(state, 0).execute();

        new Division(state).execute();

        assertEquals("Infinity", state.getCurrentValue());
    }

    @Test
    void powerTest() {
        new InsertNumber(state, 2).execute();
        new Power(state, 3).execute();

        assertEquals("8", state.getCurrentValue());
    }

    @Test
    void squareRootTest() {
        new InsertNumber(state, 9).execute();
        new SquareRoot(state).execute();

        assertEquals("3", state.getCurrentValue());
    }

    @Test
    void reciprocalTest() {
        new InsertNumber(state, 2).execute();
        new Reciprocal(state).execute();

        assertEquals("0.5", state.getCurrentValue());
    }
}