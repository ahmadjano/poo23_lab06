package calculator;

import util.Stack;

public class State {
    private String currentValue = "0"; // value currently being inputted

    private final Stack<String> stack = new Stack<>(); // stack of all values

    public State() {
    }

    public String getCurrentValue() {
        return this.currentValue;
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

    public void addNumberToCurrentValue(int number){
        if (this.currentValue.equals("0")){
            this.currentValue = Integer.toString(number);
            return;
        }
        this.currentValue += number;
    }

    public void addDecimalToCurrentValue(){
        if(this.currentValue.contains(".")){
            return;
        }
        this.currentValue += '.';
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
        if(this.stack.isEmpty()){
            return new String[] {"< empty stack >"};
        }
        return this.stack.toArray(new String[this.stack.size()]);
    }
}
