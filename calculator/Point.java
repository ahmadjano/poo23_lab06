package calculator;

public class Point extends Operator{
    public Point(State state) {
        super(state);
    }

    /**
     *
     */
    @Override
    void execute() {
        this.state.addDecimalToCurrentValue();
    }
}
