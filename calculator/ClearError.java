package calculator;

/**
 * ClearError class
 */
public class ClearError extends Operator {

    /**
     * ClearError constructor
     * @param state - State
     */
    public ClearError(State state) {
        super(state);
    }

    /**
     * Execute method
     * Reset the current value and removes errors
     */
    @Override
    public void execute() {
        this.state.resetCurrentValue();
        // remove errors
    }
}
