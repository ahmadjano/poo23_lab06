package calculator;

// could be called submit
public class Enter extends Operator {
    public Enter(State state) {
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
