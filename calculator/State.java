package calculator;
import util.Stack;

/**
 * State Class
 */
public class State {
    private static final String DEFAULT_VALUE = "0";
    private String currentValue = DEFAULT_VALUE; // value currently being inputted
    private boolean evaluated = false;
    private String storedValue = null;
    private Stack<String> stack = new Stack<>(); // stack of all values

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

    public void resetCurrentValue(){
        this.currentValue = DEFAULT_VALUE;
    }

    public void evaluate(){
        this.evaluated = true;
    }

    public void resetEvaluation(){
        this.evaluated = false;
    }

    public boolean hasBeenEvaluated(){
        return this.evaluated;
    }

    public void pushToStack(){
        this.stack.push(currentValue);
        this.resetCurrentValue();
    }

    public String popFromStack(){
        return this.stack.pop();
    }

    public String[] getStack(){
        return this.stack.toArray(new String[this.stack.size()]);
    }

    public void setStack(Stack<String> stack){
        this.stack = stack;
    }

    public boolean isEmpty() {
        return this.currentValue.equals(DEFAULT_VALUE);
    }
}
