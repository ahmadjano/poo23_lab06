package calculator;

/**
 * Submit class
 */
public class Submit extends Operator {

    /**
     * Submit constructor
     * @param state - State
     */
    public Submit(State state) {
        super(state);
    }

    /**
     * Execute method
     * push the currentvalue to the stack
     */
    @Override
    public void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            this.state.pushToStack();
            this.state.resetCurrentValue();
            this.state.updateStatus(State.CalculatorState.INPUT);
        }
    }
}
