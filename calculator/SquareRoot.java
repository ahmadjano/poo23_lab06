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
        double number = Double.parseDouble(this.state.popFromStack());
        number = Math.sqrt(number);
        String resultString = (int) number - number == 0.0
                ? Integer.toString((int) number)
                : Double.toString(number);
        this.state.pushToStack(resultString);
    }

}
