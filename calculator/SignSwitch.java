package calculator;

/**
 * SignSwitch class represents an operator that switches the sign of the currentValue.
 */
public class SignSwitch extends Operator {

    /**
     * SignSwitch constructor initializes the SignSwitch operator with the calculator's state.
     *
     * @param state - State
     */
    public SignSwitch(State state) {
        super(state);
    }

    /**
     * Execute method switches the sign of the current state value.
     * If the current value is positive, it becomes negative, and vice versa.
     */
    @Override
    void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            return;
        }

        String currentValue = this.state.getCurrentValue();
        if (currentValue.startsWith("-")) {
            // If the current value is negative, remove the '-' sign.
            this.state.setCurrentValue(currentValue.substring(1));
        } else {
            // If the current value is positive, add a '-' sign.
            this.state.setCurrentValue('-' + currentValue);
        }

    }
}
