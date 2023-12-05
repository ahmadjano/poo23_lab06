package calculator;

public class Number extends Operator{
    int value;
    public Number(State state, int value) {
        super(state);
        this.value = value;
    }

    @Override
    void execute() {
        String strValue = Integer.toString(value);
        if (this.state.isEmpty()){
            this.state.setCurrentValue(strValue);
            return;
        }
        this.state.setCurrentValue(this.state.getCurrentValue() + strValue);
    }
}
