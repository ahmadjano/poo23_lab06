package calculator;

public class State {
    private String currentValue = "0"; // value currently being inputted

    private final Stack<Double> values; // stack of all values

    public State() {
        this.values = new Stack<Double>();
    }

    public String getCurrentValue() {
        return this.currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
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

    // Add more state-related methods as needed
}
