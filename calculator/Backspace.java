package calculator;

/**
 * Backspace class represents an operator used to remove the last character in the current value.
 */
public class Backspace extends Operator {

    /**
     * Backspace constructor.
     *
     * @param state - The current state of the calculator.
     */
    public Backspace(State state) {
        super(state);
    }

    /**
     * Removes the last character from the current value.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            // If the calculator is in an error state, do nothing.
            return;
        }

        String currentValue = this.state.getCurrentValue();
        if (currentValue.length() <= 1) {
            // If the current value has only one character or is empty, reset the current value.
            this.state.resetCurrentValue();
        } else {
            // Remove the last character from the current value.
            this.state.setCurrentValue(currentValue.substring(0, currentValue.length() - 1));
        }
    }
}
