package calculator;

/**
 * ArithmeticOperator class
 * Abstract class for simple arithmetic operations between two numbers
 * (like addition, subtraction, etc...)
 */
public abstract class ArithmeticOperator extends Operator{
    /**
     * ArithmeticOperator constructor
     * @param state - State
     */
    public ArithmeticOperator(State state) {
        super(state);
    }

    /**
     * Performs an operation with 2 numbers
     * @param d1 - first double
     * @param d2 - second double
     * @return result of operation
     */
    protected abstract Double performOperation(double d1, double d2);

    /**
     * Execute method
     * Uses the first value on top of the stack and the currentvalue to get a new value
     */
    @Override
    void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)){
            // from stack
            double n1 = Double.parseDouble(this.state.popFromStack());

            // from current value
            double n2 = this.state.getCurrentValueAsDouble();
            this.state.setCurrentValueFromDouble(performOperation(n1, n2));
            this.state.updateStatus(State.CalculatorState.POST_OPERATION);
        }
    }
}
