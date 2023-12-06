package calculator;

/**
 * ArithmeticOperator class represents an abstract class for simple arithmetic operations between two numbers
 * (like addition, subtraction, multiplication and division)
 */
public abstract class ArithmeticOperator extends Operator {

    /**
     * ArithmeticOperator constructor.
     *
     * @param state - The current state of the calculator.
     */
    public ArithmeticOperator(State state) {
        super(state);
    }

    /**
     * Performs an arithmetic operation with two numbers.
     *
     * @param d1 - The first double operand.
     * @param d2 - The second double operand.
     * @return The result of the arithmetic operation.
     * @throws ArithmeticException if an arithmetic error occurs during the operation, division typically.
     */
    protected abstract Double performOperation(double d1, double d2) throws ArithmeticException;

    /**
     * Execute method for arithmetic operations.
     * Uses the first value on top of the stack and the current value to perform the operation and update the state.
     */
    @Override
    void execute() {
        if (this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            // If the calculator is in an error state, do nothing.
            return;
        }

        // Retrieve the first operand from the stack.
        double n1 = Double.parseDouble(this.state.popFromStack());

        // Retrieve the second operand from the current value.
        double n2 = this.state.getCurrentValueAsDouble();

        try {
            // Perform the arithmetic operation and set the result as the new current value.
            this.state.setCurrentValueFromDouble(performOperation(n1, n2));
        } catch (ArithmeticException e) {
            // Handle arithmetic errors by updating the calculator state and displaying an error message.
            this.state.updateStatus(State.CalculatorState.ERROR);
            // Undo the pop and push the original value back to the stack.
            state.setCurrentValueFromDouble(n1);
            this.state.pushToStack();
            // Set the current value to the error message.
            state.setCurrentValue(e.getMessage());
            return;
        }

        // Update the calculator state after a successful operation.
        this.state.updateStatus(State.CalculatorState.POST_OPERATION);
    }
}
