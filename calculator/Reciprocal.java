/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * Reciprocal class represents an operator that applies the reciprocal operation (1/x) to the current value.
 * It extends the Operator class.
 */
public class Reciprocal extends Operator {
    /**
     * Reciprocal constructor initializes the Reciprocal operator with the calculator's state.
     *
     * @param state - State
     */
    public Reciprocal(State state) {
        super(state);
    }

    /**
     * Execute method applies the reciprocal operation (1/x) on the currentValue.
     * Updates the current value and sets the calculator status to POST_OPERATION.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            return;
        }

        double number = this.state.getCurrentValueAsDouble();
        if (number == 0.0) {
            this.state.updateStatus(State.CalculatorState.ERROR);
            this.state.setCurrentValue("Division by zero is not allowed");
        } else {
            number = 1 / number;
            this.state.setCurrentValueFromDouble(number);
            this.state.updateStatus(State.CalculatorState.POST_OPERATION);
        }

    }
}
