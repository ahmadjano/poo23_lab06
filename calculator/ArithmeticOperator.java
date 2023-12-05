package calculator;

public abstract class ArithmeticOperator extends Operator{
    public ArithmeticOperator(State state) {
        super(state);
    }

    protected abstract Double performOperation(double d1, double d2);

    @Override
    void execute() {
        double n1 = Double.parseDouble(this.state.popFromStack());
        double n2 = Double.parseDouble(this.state.popFromStack());
        String result = Double.toString(performOperation(n1,n2));

        if (result.endsWith(".0")) {
            state.pushToStack(result.replace(".0", ""));
        } else {
            state.pushToStack(result);
        }
    }
}
