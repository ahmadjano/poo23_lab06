package calculator;

public class Backspace extends Operator{
    public Backspace(State state) {
        super(state);
    }

    /**
     *
     */
    @Override
    void execute() {
        String currentValue = this.state.getCurrentValue();
        this.state.setCurrentValue(currentValue.substring(0, currentValue.length() - 1));
    }
}
