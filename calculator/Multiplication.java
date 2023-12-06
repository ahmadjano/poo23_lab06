/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * Multiplication class represents an operator that multiplies two values in the calculator.
 */
public class Multiplication extends ArithmeticOperator {

    /**
     * Multiplication constructor initializes the Multiplication operator with the calculator's state.
     *
     * @param state - State
     */
    public Multiplication(State state) {
        super(state);
    }

    /**
     * Perform the multiplication operation on two double values.
     *
     * @param d1 - first double
     * @param d2 - second double
     * @return double - result of multiplication
     */
    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 * d2;
    }
}
