package calculator;

/**
 * Multiplication class
 */
public class Multiplication extends ArithmeticOperator{

    /**
     * Multiplication constructor
     * @param state - State
     */
    public Multiplication(State state) {
        super(state);
    }

    /**
     * Multiplies the 2 values
     * @param d1 - first double
     * @param d2 - second double
     * @return double - result of multiplication
     */
    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 * d2;
    }
}
