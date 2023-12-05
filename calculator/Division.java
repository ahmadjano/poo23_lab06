package calculator;

/**
 * Division Class
 */
public class Division extends ArithmeticOperator{
    /**
     * Division constructor
     * @param state - State
     */
    public Division(State state) {
        super(state);
    }

    /**
     * divides the first double by the 2nd
     * @param d1 - first double
     * @param d2 - second double
     * @return double - result of operation
     */
    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 / d2;
    }
}
