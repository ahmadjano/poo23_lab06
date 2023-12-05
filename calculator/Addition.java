package calculator;

public class Addition extends ArithmeticOperator{
    public Addition(State state) {
        super(state);
    }

    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 + d2;
    }
}
