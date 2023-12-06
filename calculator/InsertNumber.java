package calculator;

/**
 * InsertNumber class
 */
public class InsertNumber extends Operator{
    private final String value;

    /**
     * @param state - State
     * @param value - Value to add
     */
    public InsertNumber(State state, int value) {
        super(state);
        this.value = Integer.toString(value);
    }

    /**
     * Execute Method
     * Adds the number to the currentvalue
     * If the currentvalue has been operated on before, push it to the stack
     */
    @Override
    void execute() {
        if (this.state.getStatus() == State.CalculatorState.ERROR) {
            // Override the existing error with new value entered.
            this.state.updateStatus(State.CalculatorState.INPUT);
            this.state.setCurrentValue(value);
            return;
        }

        if (this.state.getStatus() == State.CalculatorState.POST_OPERATION) {
            this.state.updateStatus(State.CalculatorState.INPUT);
            this.state.pushToStack();
            this.state.resetCurrentValue();
        }
        if (this.state.isEmpty()) {
            this.state.setCurrentValue(value);
        } else {
            this.state.setCurrentValue(this.state.getCurrentValue() + value);
        }


    }
}
