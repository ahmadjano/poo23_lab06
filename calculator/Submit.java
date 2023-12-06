/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * Submit class represents the submit operation in the calculator.
 * It pushes the current value to the stack, resets the current value, and updates the calculator state.
 */
public class Submit extends Operator {

    /**
     * Submit constructor.
     *
     * @param state - State
     */
    public Submit(State state) {
        super(state);
    }

    /**
     * Execute method performs the submit operation.
     * It pushes the current value to the stack, resets the current value, and updates the calculator state.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            return;
        }

        this.state.pushToStack();
        this.state.resetCurrentValue();
        this.state.updateStatus(State.CalculatorState.INPUT);
    }
}
