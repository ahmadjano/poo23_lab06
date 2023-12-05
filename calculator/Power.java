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
        double number = this.state.getCurrentValueAsDouble();
        number = Math.pow(number,this.exponent);
        this.state.setCurrentValueFromDouble(number);
        this.state.evaluate();
    }
}
