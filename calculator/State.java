package calculator;

import util.Stack;

public class State {
    public static final String DEFAULT_VALUE = "0";
    private static final String[] DEFAULT_STACK = new String[] {"< empty stack >"};
    private String currentValue = DEFAULT_VALUE; // value currently being inputted

    private boolean evaluated = false;

    private Stack<String> stack = new Stack<>(); // stack of all values

    public String getCurrentValue() {
        return this.currentValue;
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
    public Double getCurrentValueAsDouble() {
        return Double.parseDouble(this.currentValue);
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public void setCurrentValueFromDouble(double value) {
        String resultString = (int) value - value == 0.0
                ? Integer.toString((int) value)
                : Double.toString(value);
        this.setCurrentValue(resultString);
    }

    public void resetCurrentValue(){
        this.currentValue = DEFAULT_VALUE;
    }

    public void pushToStack(){
        this.stack.push(currentValue);
        this.resetCurrentValue();
    }

    public void pushToStack(String value){
        this.stack.push(value);
    }

    public String popFromStack(){
        return this.stack.pop();
    }

    public String[] getStack(){
        if(this.stack.isEmpty()){
            return DEFAULT_STACK;
        }
        return this.stack.toArray(new String[this.stack.size()]);
    }

    public void setStack(Stack<String> stack){
        this.stack = stack;
    }
}
