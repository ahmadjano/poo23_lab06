package calculator;

public class ClearError extends Operator {

    public ClearError(State state) {
        super(state);
    }

    @Override
    void execute() {
        state.setCurrentValue("0");
    }
}
