package calculator;

/**
 * Backspace class
 * Used to remove the last character in current value
 */
public class Backspace extends Operator{

    /**
     * Backspace constructor
     * @param state - State
     */
    public Backspace(State state) {
        super(state);
    }

    /**
     * Execute method
     * Removes the last character from current value
     */
    @Override
    void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            String currentValue = this.state.getCurrentValue();
            this.state.setCurrentValue(currentValue.substring(0, currentValue.length() - 1));
        }
    }
}
