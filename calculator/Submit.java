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
    void execute() {
        this.state.pushToStack();
        this.state.resetCurrentValue();
        this.state.resetEvaluation();
    }
}
