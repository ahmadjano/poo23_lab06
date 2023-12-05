package calculator;

/**
 * Addition class
 * Adds 2 value together and return the result
 */
public class Addition extends ArithmeticOperator{
    /**
     * Addition constructor
     * @param state - State
     */
    public Addition(State state) {
        super(state);
    }

    /**
     * @param d1 - first double
     * @param d2 - second double
     * @return result of the operation
     */
    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 + d2;
    }
}
