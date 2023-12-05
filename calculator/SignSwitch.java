package calculator;

public class SignSwitch extends Operator{
    public SignSwitch(State state) {
        super(state);
    }

    /**
     *
     */
    @Override
    void execute() {
        this.state.setCurrentValue(-this.state.getCurrentValue());
    }
}
