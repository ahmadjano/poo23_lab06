package calculator;

public class Subtraction extends ArithmeticOperator{
    public Subtraction(State state) {
        super(state);
    }

    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 - d2;
    }

}
