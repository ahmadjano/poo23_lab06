package calculator;

public class SquareRoot extends Operator {
    public SquareRoot(State state) {
        super(state);
    }

    /**
     * Performs a square root operation.
     */
    @Override
    void execute() {
        double number = this.state.getCurrentValueAsDouble();
        number = Math.sqrt(number);
        this.state.setCurrentValueFromDouble(number);
        this.state.evaluate();
    }
}
