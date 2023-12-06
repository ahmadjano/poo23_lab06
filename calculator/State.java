package calculator;
import util.Stack;

/**
 * State Class represents the internal state of the calculator, including the current value, stored value, and stack.
 * It also defines methods to perform operations on the state.
 */
public class State {
    private static final String DEFAULT_VALUE = "0";
    private String currentValue = DEFAULT_VALUE; // value currently being inputted
    private String storedValue = null;
    private Stack<String> stack = new Stack<>(); // stack of all values

    private CalculatorState status = CalculatorState.EMPTY;

    /**
     * Store the current value and then reset it.
     */
    public void storeValue() {
        this.storedValue = this.currentValue;
        this.resetCurrentValue();
    }

    /**
     * Recall the stored value and replace the current one with it.
     */
    public void recallValue() {
        if (this.storedValue != null) {
            this.currentValue = this.storedValue;
        }
    }

    /**
     * Returns the current value as a String.
     *
     * @return String - current value
     */
    public String getCurrentValue() {
        return this.currentValue;
    }

    /**
     * Get the current value as a double.
     *
     * @return Double - current value as double
     */
    public Double getCurrentValueAsDouble() {
        return Double.parseDouble(this.currentValue);
    }

    /**
     * Set the current value.
     *
     * @param value - value to be set as current
     */
    public void setCurrentValue(String value) {
        this.currentValue = value;
    }

    /**
     * Set the current value from a double.
     *
     * @param value - value to be set as current in double
     */
    public void setCurrentValueFromDouble(double value) {
        String resultString = (int) value - value == 0.0
                ? Integer.toString((int) value)
                : Double.toString(value);
        this.setCurrentValue(resultString);
    }

    /**
     * Reset the current value to default.
     */
    public void resetCurrentValue() {
        this.currentValue = DEFAULT_VALUE;
    }

    /**
     * Update the status.
     *
     * @param status - Status to be set
     */
    public void updateStatus(CalculatorState status) {
        this.status = status;
    }

    /**
     * Returns the current status.
     *
     * @return CalculatorState
     */
    public CalculatorState getStatus() {
        return this.status;
    }

    /**
     * Push the current value to the stack and then reset it.
     */
    public void pushToStack() {
        this.stack.push(currentValue);
    }

    /**
     * Pop the top value from the stack and return it.
     *
     * @return String - value
     */
    public String popFromStack() {
        return this.stack.pop();
    }

    /**
     * Returns the stack.
     *
     * @return Stack<String>
     */
    public Stack<String> getStack() {
        return stack;
    }

    /**
     * Returns the stack as an array.
     *
     * @return String[]
     */
    public String[] toArray() {
        return this.stack.toArray(new String[stack.size()]);
    }

    /**
     * Set a new stack.
     *
     * @param stack - Stack
     */
    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    /**
     * Check if the currentValue is empty.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return this.currentValue.equals(DEFAULT_VALUE);
    }

    /**
     * Enumeration representing the possible states of the calculator.
     */
    public enum CalculatorState {
        EMPTY,
        INPUT,    // Input mode for entering numbers
        POST_OPERATION,
        ERROR,    // Error state
    }
}
