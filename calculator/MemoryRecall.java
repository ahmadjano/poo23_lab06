package calculator;

/**
 * MemoryRecall class represents an operator that recalls the stored value in the calculator's state.
 */
public class MemoryRecall extends Operator {

    /**
     * MemoryRecall constructor initializes the MemoryRecall operator with the calculator's state.
     *
     * @param state - State
     */
    public MemoryRecall(State state) {
        super(state);
    }

    /**
     * Execute method recalls the stored value from the state if the calculator is not in an error state.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            return;
        }

        this.state.recallValue();
    }
}
