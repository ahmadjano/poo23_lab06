package calculator;

public class Number extends Operator{
    int value;
    public Number(State state, int value) {
        super(state);
        this.value = value;
    }

    @Override
    void execute() {
        if(this.state.hasBeenEvaluated()){
            this.state.resetEvaluation();
            this.state.pushToStack();
        }
        String strValue = Integer.toString(value);
        if (this.state.getCurrentValue().equals(State.DEFAULT_VALUE)){
            this.state.setCurrentValue(strValue);
            return;
        }
        this.state.setCurrentValue(this.state.getCurrentValue() + strValue);
    }
}
