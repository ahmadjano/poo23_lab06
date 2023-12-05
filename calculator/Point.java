package calculator;

public class Point extends Operator{
    public Point(State state) {
        super(state);
    }

    /**
     * Appends a decimal point to the current state.
     */
    @Override
    void execute() {
        if(this.state.getCurrentValue().contains(".")){
            return;
        }
        this.state.setCurrentValue(this.state.getCurrentValue() + '.');
    }
}
