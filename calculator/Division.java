/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * Division class represents an arithmetic operator that performs division between two numbers.
 */
public class Division extends ArithmeticOperator {

    /**
     * Division constructor initializes the Division operator with the calculator's state.
     *
     * @param state - State
     */
    public Division(State state) {
        super(state);
    }

    /**
     * Performs division operation on two doubles.
     *
     * @param d1 - the first double
     * @param d2 - the second double (divisor)
     * @return double - result of the division operation
     * @throws ArithmeticException if attempting to divide by zero
     */
    @Override
    protected Double performOperation(double d1, double d2) throws ArithmeticException {
        if (d2 == 0.0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return d1 / d2;
    }
}
