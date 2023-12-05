package calculator;

public class InsertNumber extends Operator{
    int value;
    public InsertNumber(State state, int value) {
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
