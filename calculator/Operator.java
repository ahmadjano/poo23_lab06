/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * Operator class is an abstract class representing operators in the calculator.
 * It serves as the base class for all operators.
 */
public abstract class Operator {

    protected final State state;

    /**
     * Operator constructor initializes the operator with the calculator's state.
     *
     * @param state - State
     */
    public Operator(State state) {
        this.state = state;
    }

    /**
     * Execute method to be implemented by subclasses to define the behavior of the operator.
     */
    public abstract void execute();
}
