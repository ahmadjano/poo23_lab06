package calculator;

public class Multiplication extends ArithmeticOperator{
    public Multiplication(State state) {
        super(state);
    }

    @Override
    protected Double performOperation(double d1, double d2) {
        return d1 * d2;
    }

}
