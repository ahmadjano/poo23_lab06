package calculator;

/**
 * Addition class represents an operator for adding two values together and returning the result.
 */
public class Addition extends ArithmeticOperator {

    /**
     * Addition constructor.
     *
     * @param state - The current state of the calculator.
     */
    public Addition(State state) {
        super(state);
    }

    /**
     * Performs the addition operation on two double values.
     *
     * @param d1 - The first double value.
     * @param d2 - The second double value.
     * @return The result of the addition operation.
     */
    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 + d2;
    }
}
