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
        String currentValue = this.state.getCurrentValue();
        if (currentValue.startsWith("-")) {
            this.state.setCurrentValue(currentValue.substring(1));
        } else {
            this.state.setCurrentValue('-' + currentValue);
        }
    }
}
