package calculator;

/**
 * Power class
 */
public class Power extends Operator{
    private final int exponent;

    /**
     * Power constructor
     * @param state - State
     * @param exponent - Exponent for the power
     */
    public Power(State state, int exponent) {
        super(state);
        this.exponent = exponent;
    }

    /**
     * Execute method
     * Applies power to the current value
     */
    @Override
    public void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            double number = this.state.getCurrentValueAsDouble();
            number = Math.pow(number, this.exponent);
            this.state.setCurrentValueFromDouble(number);
            this.state.updateStatus(State.CalculatorState.POST_OPERATION);
        }
    }
}
