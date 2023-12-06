package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void insertionTest() {
        calculator.submitValue("1");
        calculator.submitValue("-1");
        calculator.submitValue("99");
        calculator.submitValue("2.5");
        calculator.submitValue("-78.23");

        assertEquals("[-78.23, 2.5, 99, -1, 1]", calculator.state.getStack().toString());
    }

    @Test
    public void clearTest() {
        calculator.submitValue("1");
        calculator.submitValue("-1");
        calculator.submitValue("99");
        calculator.submitValue("2.5");
        calculator.submitValue("-78.23");

        calculator.executeOperation("clear");

        assertEquals("[]", calculator.state.getStack().toString());
    }

    @Test
    public void invalidOperatorTest() {
        calculator.submitValue("5");
        calculator.submitValue("10");

        assertThrows(IllegalArgumentException.class, () -> calculator.executeOperation("lol"));

        // Check that the stack remains unchanged
        assertEquals("[10, 5]", calculator.state.getStack().toString());
    }

    @Test
    public void additionTest() {
        calculator.submitValue("-4.2");
        calculator.submitValue("-6.3");
        calculator.executeOperation("+");
        assertEquals("[-10.5]", calculator.state.getStack().toString());
    }

    @Test
    public void additionMultipleTest() {
        calculator.submitValue("5");
        calculator.submitValue("10");
        calculator.submitValue("20");
        calculator.executeOperation("+");
        calculator.executeOperation("+");
        assertEquals("[35]", calculator.state.getStack().toString());
    }

    @Test
    public void subtractionTest() {
        calculator.submitValue("42");
        calculator.submitValue("10");
        calculator.submitValue("64");
        calculator.executeOperation("-");
        calculator.executeOperation("-");
        assertEquals("[96]", calculator.state.getStack().toString());
    }

    @Test
    public void multiplicationTest() {
        calculator.submitValue("2.5");
        calculator.submitValue("-7.75");
        calculator.submitValue("6");
        calculator.executeOperation("*");
        calculator.executeOperation("*");
        assertEquals("[-116.25]", calculator.state.getStack().toString());
    }

    @Test
    public void divitionTest() {
        calculator.submitValue("5");
        calculator.submitValue("2");
        calculator.executeOperation("/");
        assertEquals("[2.5]", calculator.state.getStack().toString());
    }

    @Test
    public void powerTest() {
        calculator.submitValue("2.5");
        calculator.submitValue("-5.5");
        calculator.executeOperation("exp2");
        assertEquals("[30.25, 2.5]", calculator.state.getStack().toString());
    }

    @Test
    public void sqrtTest() {
        calculator.submitValue("2.5");
        calculator.submitValue("16");
        calculator.executeOperation("sqrt");
        assertEquals("[4, 2.5]", calculator.state.getStack().toString());
    }

    @Test
    public void sqrtNegativeTest() {
        calculator.submitValue("-1");

        assertThrows(IllegalArgumentException.class, () -> calculator.executeOperation("sqrt"));
        assertEquals("[-1]", calculator.state.getStack().toString());
    }

    @Test
    public void reciprocalTest() {
        calculator.submitValue("2");
        calculator.executeOperation("reciprocal");

        assertEquals("[0.5]", calculator.state.getStack().toString());
    }

    @Test
    public void reciprocalZeroTest() {
        calculator.submitValue("0");

        assertThrows(IllegalArgumentException.class, () -> calculator.executeOperation("reciprocal"));
    }


}