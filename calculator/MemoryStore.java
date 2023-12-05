package calculator;

/**
 * MemoryStore class
 * Store currentValue
 */
public class MemoryStore extends Operator{

    /**
     * MemoryStore constructor
     * @param state - State
     */
    public MemoryStore(State state) {
        super(state);
    }

    /**
     * Execute method
     * Store the currentValue in the state
     */
    @Override
    void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            this.state.storeValue();
        }
    }
}
