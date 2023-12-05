package calculator;

public abstract class ArithmeticOperator extends Operator{
    public ArithmeticOperator(State state) {
        super(state);
    }

    protected abstract Double performOperation(double d1, double d2);

    @Override
    void execute() {
        double n1 = Double.parseDouble(this.state.popFromStack());
        double n2 = this.state.getCurrentValueAsDouble();
        this.state.setCurrentValueFromDouble(performOperation(n1, n2));
        this.state.evaluate();
    }
}
