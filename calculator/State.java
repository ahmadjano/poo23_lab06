package calculator;

import util.Stack;

public class State {
    private static final String DEFAULT_VALUE = "0";
    private String currentValue = DEFAULT_VALUE; // value currently being inputted

    private Stack<String> stack = new Stack<>(); // stack of all values

    public String getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public void pushToStack(){
        this.stack.push(currentValue);
    }

    public void pushToStack(String value){
        this.stack.push(value);
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

    public void resetValue() {
        this.currentValue = DEFAULT_VALUE;
    }

    public boolean isEmpty() {
        return this.currentValue.equals(DEFAULT_VALUE);
    }
}
