package calculator;

/**
 * SquareRoot class
 */
public class SquareRoot extends Operator {

    /**
     * SquareRoot constructor
     * @param state - State
     */
    public SquareRoot(State state) {
        super(state);
    }

    /**
     * Execute method
     * Performs a square root operation on the currentValue.
     */
    @Override
    void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            double number = this.state.getCurrentValueAsDouble();
            number = Math.sqrt(number);
            this.state.setCurrentValueFromDouble(number);
            this.state.updateStatus(State.CalculatorState.POST_OPERATION);
        }
    }
}
