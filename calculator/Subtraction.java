package calculator;

/**
 * Subtraction class
 */
public class Subtraction extends ArithmeticOperator{

    /**
     * Subtraction constructor
     * @param state - State
     */
    public Subtraction(State state) {
        super(state);
    }

    /**
     * Subtracts the second number to the first
     * @param d1 - first double
     * @param d2 - second double
     * @return double - result of subtraction
     */
    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 - d2;
    }

}
