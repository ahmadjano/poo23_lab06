package calculator;
import util.Stack;

/**
 * State Class
 */
public class State {
    private static final String DEFAULT_VALUE = "0";
    private String currentValue = DEFAULT_VALUE; // value currently being inputted
    private String storedValue = null;
    private Stack<String> stack = new Stack<>(); // stack of all values

    private CalculatorState status = CalculatorState.INPUT;

    /**
     * Store the current value
     * Then reset it
     */
    public void storeValue(){
        this.storedValue = this.currentValue;
        this.resetCurrentValue();
    }

    /**
     * Recall the stored value and replace the current one by it
     */
    public void recallValue(){
        if (this.storedValue != null){
            this.currentValue = this.storedValue;
        }
    }

    /**
     * Returns the current value as String
     * @return String - current value
     */
    public String getCurrentValue() {
        return this.currentValue;
    }

    /**
     * Get current value as double
     * @return Double - current value as double
     */
    public Double getCurrentValueAsDouble() {
        return Double.parseDouble(this.currentValue);
    }

    /**
     * Set the current value
     * @param value - value to bet set as current
     */
    public void setCurrentValue(String value) {
        this.currentValue = value;
    }

    /**
     * Set the current value from a double
     * @param value - value to be set as current in double
     */
    public void setCurrentValueFromDouble(double value) {
        String resultString = (int) value - value == 0.0
                ? Integer.toString((int) value)
                : Double.toString(value);
        this.setCurrentValue(resultString);
    }

    /**
     * Reset current value to default
     */
    public void resetCurrentValue(){
        this.currentValue = DEFAULT_VALUE;
    }

    /**
     * Update the status
     * @param status - Status to be set
     */
    public void updateStatus(CalculatorState status){
        this.status = status;
    }

    /**
     * Returns the current status
     * @return CalculatorState
     */
    public CalculatorState getStatus(){
        return this.status;
    }

    /**
     * Pushes current value to stack then reset it
     */
    public void pushToStack(){
        this.stack.push(currentValue);
    }

    /**
     * Pops the top value from stack and return it
     * @return String - value
     */
    public String popFromStack(){
        return this.stack.pop();
    }

    /**
     * Returns the stack
     * @return Stack<String>
     */
    public Stack<String> getStack() {
        return stack;
    }

    /**
     * Returns the stack as array
     * @return String[]
     */
    public String[] toArray() {
        return this.stack.toArray(new String[stack.size()]);
    }

    /**
     * Set a new stack
     * @param stack - Stack
     */
    public void setStack(Stack<String> stack){
        this.stack = stack;
    }

    /**
     * Check if currentValue is empty
     * @return boolean
     */
    public boolean isEmpty() {
        return this.currentValue.equals(DEFAULT_VALUE);
    }

    public enum CalculatorState {
        POST_OPERATION,
        ERROR,    // Error state
        INPUT,    // Input mode for entering numbers
    }
}
