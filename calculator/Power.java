package calculator;

/**
 * Power class represents an operator that applies exponentiation to the current value.
 */
public class Power extends Operator {
    private final int exponent;

    /**
     * Power constructor initializes the Power operator with the calculator's state and exponent.
     *
     * @param state    - State
     * @param exponent - Exponent for the power
     */
    public Power(State state, int exponent) {
        super(state);
        this.exponent = exponent;
    }

    /**
     * Execute method applies the power operation to the current value.
     * Updates the current value and sets the calculator status to POST_OPERATION.
     */
    @Override
    public void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            return;
        }

        double number = this.state.getCurrentValueAsDouble();
        number = Math.pow(number, this.exponent);
        this.state.setCurrentValueFromDouble(number);
        this.state.updateStatus(State.CalculatorState.POST_OPERATION);

    }
}
