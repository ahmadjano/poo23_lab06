package calculator;

/**
 * MemoryStore class represents an operator that stores the current value in the calculator's state.
 */
public class MemoryStore extends Operator {

    /**
     * MemoryStore constructor initializes the MemoryStore operator with the calculator's state.
     *
     * @param state - State
     */
    public MemoryStore(State state) {
        super(state);
    }

    /**
     * Execute method stores the current value in the state if the calculator is not in an error state.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            return;
        }

        this.state.storeValue();
    }
}
