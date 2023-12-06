package calculator;

/**
 * Decimal class
 * add a decimal to currentvalue
 */
public class Decimal extends Operator{

    /**
     * Decimal constructor
     * @param state - State
     */
    public Decimal(State state) {
        super(state);
    }

    /**
     * Execute method
     * Appends a decimal point to the current state.
     */
    @Override
    public void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {

            if (this.state.getCurrentValue().contains(".")) {
                return;
            }
            this.state.setCurrentValue(this.state.getCurrentValue() + '.');
        }
    }
}
