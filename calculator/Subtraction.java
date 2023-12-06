/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * Subtraction class represents the subtraction operation in the calculator.
 * It subtracts the second number from the first.
 */
public class Subtraction extends ArithmeticOperator {

    /**
     * Subtraction constructor.
     *
     * @param state - State
     */
    public Subtraction(State state) {
        super(state);
    }

    /**
     * Perform subtraction operation.
     *
     * @param d1 - first double
     * @param d2 - second double
     * @return double - result of subtraction
     */
    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 - d2;
    }
}
