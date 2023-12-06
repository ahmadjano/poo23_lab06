/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * Decimal class represents an operator that adds a decimal point to the current value in the calculator.
 */
public class Decimal extends Operator {

    /**
     * Decimal constructor initializes the Decimal operator with the calculator's state.
     *
     * @param state - State
     */
    public Decimal(State state) {
        super(state);
    }

    /**
     * Execute method appends a decimal point to the current state if the calculator is not in an error state.
     * If the current value already contains a decimal point, no action is taken.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            return;
        }

        if (this.state.getCurrentValue().contains(".")) {
            return; // No action if the current value already contains a decimal point.
        }

        this.state.setCurrentValue(this.state.getCurrentValue() + '.');

    }
}
