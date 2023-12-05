package calculator;

public class Submit extends Operator {
    public Submit(State state) {
        super(state);
    }

    /**
     *
     */
    @Override
    void execute() {
        // push the currentValue on top of the stack
        // then set it to 0
        this.state.pushToStack();
        this.state.resetCurrentValue();
    }
}
