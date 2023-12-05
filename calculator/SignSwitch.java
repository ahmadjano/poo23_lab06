package calculator;

/**
 * SignSwitch class
 * Switch sign of the currentValue
 */
public class SignSwitch extends Operator{

    /**
     * SignSwitch constructor
     * @param state - State
     */
    public SignSwitch(State state) {
        super(state);
    }

    /**
     * Execute method
     * Switches the sign of the current state value.
     */
    @Override
    void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            String currentValue = this.state.getCurrentValue();
            if (currentValue.startsWith("-")) {
                this.state.setCurrentValue(currentValue.substring(1));
            } else {
                this.state.setCurrentValue('-' + currentValue);
            }
        }
    }
}
