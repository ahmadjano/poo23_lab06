package calculator;

public class Multiplication extends Operator{
    public Multiplication(State state) {
        super(state);
    }

    @Override
    void execute() {
        double n1 = Double.parseDouble(this.state.popFromStack());
        double n2 = Double.parseDouble(this.state.popFromStack());
        String result = Double.toString(n1 * n2);

        if (result.endsWith(".0")) {
            state.pushToStack(result.replace(".0", ""));
        } else {
            state.pushToStack(result);
        }
    }
}
