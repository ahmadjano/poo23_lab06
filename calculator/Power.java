package calculator;

public class Power extends Operator{
    private int exponent;
    public Power(State state, int exponent) {
        super(state);
        this.exponent = exponent;
    }

    /**
     *
     */
    @Override
    void execute() {
        // take the first number of the stack
        // pow(2) of it
        // push it back on top of stack
        double number = this.state.getCurrentValueAsDouble();
        number = Math.pow(number,this.exponent);
        String resultString = (int) number - number == 0.0
                ? Integer.toString((int) number)
                : Double.toString(number);
        //this.state.pushToStack(resultString);
        this.state.setCurrentValue(resultString);
        this.state.evaluate();

    }
}
