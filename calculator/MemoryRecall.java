package calculator;

/**
 * MemoryRecall class
 * Recalls the storedValue in the state
 */
public class MemoryRecall extends Operator{

    /**
     * MemoryCall constructor
     * @param state - State
     */
    public MemoryRecall(State state) {
        super(state);
    }

    /**
     * Execute method
     * Recalls stored value
     */
    @Override
    void execute() {
        this.state.recallValue();
    }
}
