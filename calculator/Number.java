package calculator;

public class Number extends Operator{
    int value;
    public Number(State state, int value) {
        super(state);
        this.value = value;
    }

    @Override
    void execute() {
        this.state.addNumberToCurrentValue(this.value);
    }
}
