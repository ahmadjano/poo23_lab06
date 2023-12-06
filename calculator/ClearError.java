package calculator;

/**
 * ClearError class represents an operator that clears errors in the calculator's state.
 */
public class ClearError extends Operator {

    /**
     * ClearError constructor initializes the ClearError operator with the calculator's state.
     *
     * @param state - State
     */
    public ClearError(State state) {
        super(state);
    }

    /**
     * Execute method resets the current value and removes errors from the calculator's state.
     * It updates the status to INPUT and removes any errors that may be present.
     */
    @Override
    void execute() {
        this.state.resetCurrentValue();
        this.state.updateStatus(State.CalculatorState.INPUT);
    }
}
