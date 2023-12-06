package calculator;

/**
 * InsertNumber class represents an operator for inserting a numeric value into the calculator.
 */
public class InsertNumber extends Operator {
    private final String value;

    /**
     * Constructor for InsertNumber class.
     *
     * @param state - The current state of the calculator.
     * @param value - The numeric value to add.
     */
    public InsertNumber(State state, int value) {
        super(state);
        this.value = Integer.toString(value);
    }

    /**
     * Adds the numeric value to the current value of the calculator.
     * If the current value has been operated on before, pushes it to the stack.
     */
    @Override
    void execute() {
        // Handle the case when the calculator is in an error state.
        if (this.state.getStatus() == State.CalculatorState.ERROR) {
            // Override the existing error message with the new value entered.
            this.state.updateStatus(State.CalculatorState.INPUT);
            this.state.setCurrentValue(value);
            return;
        }

        // Handle the case when the calculator is in a post-operation state.
        if (this.state.getStatus() == State.CalculatorState.POST_OPERATION) {
            this.state.updateStatus(State.CalculatorState.INPUT);
            this.state.pushToStack();
            this.state.resetCurrentValue();
        }

        // Handle the case when the current value is empty.
        if (this.state.isEmpty()) {
            this.state.setCurrentValue(value);
        } else {
            // Append the numeric value to the existing current value.
            this.state.setCurrentValue(this.state.getCurrentValue() + value);
        }
    }
}
