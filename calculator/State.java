package calculator;

public class State {
    private double currentValue; // value currently being inputted

    private final Stack<Double> values; // stack of all values

    public State() {
        this.values = new Stack<Double>();
    }

    public double getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(double currentValue) {
        this.currentValue = currentValue;
    }

    // Add more state-related methods as needed
}