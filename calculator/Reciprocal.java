package calculator;

/**
 * Reciprocal Class
 * 1/x
 */
public class Reciprocal extends Operator{
    /**
     * Reciprocal constructor
     * @param state - State
     */
    public Reciprocal(State state) {
        super(state);
    }

    /**
     * Execute method
     * Apply 1/x on the currentValue
     */
    @Override
    void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            double number = this.state.getCurrentValueAsDouble();
            if (number != 0.0) {
                number = 1 / number;
                this.state.setCurrentValueFromDouble(number);
                this.state.updateStatus(State.CalculatorState.POST_OPERATION);
            }
        }
    }
}
