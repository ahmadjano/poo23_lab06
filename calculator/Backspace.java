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
        // removes the latest char in the currentValue
        // eg : 1234 -> 123
        // 123.4 -> 123. -> 123
    }
}
