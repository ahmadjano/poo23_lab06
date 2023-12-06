/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

/**
 * SquareRoot class represents an operator that performs a square root operation on the currentValue.
 */
public class SquareRoot extends Operator {

    /**
     * SquareRoot constructor initializes the SquareRoot operator with the calculator's state.
     *
     * @param state - State
     */
    public SquareRoot(State state) {
        super(state);
    }

    /**
     * Execute method performs a square root operation on the currentValue.
     * If the current value is negative, it sets the calculator's state to an error.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            // If the calculator is already in an error state, return.
            return;
        }

        double number = this.state.getCurrentValueAsDouble();
        if (number < 0) {
            // If the current value is negative, set the calculator's state to an error.
            this.state.updateStatus(State.CalculatorState.ERROR);
            this.state.setCurrentValue("Negative numbers with square roots are not allowed");
        } else {
            // Perform the square root operation for non-negative values.
            number = Math.sqrt(number);
            this.state.setCurrentValueFromDouble(number);
            this.state.updateStatus(State.CalculatorState.POST_OPERATION);
        }
    }
}
