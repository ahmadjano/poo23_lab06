package calculator;

public class Division extends ArithmeticOperator{
    public Division(State state) {
        super(state);
    }

    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 / d2;
    }
}
