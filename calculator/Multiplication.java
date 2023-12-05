package calculator;

public class Multiplication extends Operator{
    public Multiplication(State state) {
        super(state);
    }

    @Override
    void execute() {
        double n1,n2;
        n1 = Double.parseDouble(this.state.popFromStack());
        n2 = Double.parseDouble(this.state.popFromStack());
        double result = n1 * n2;
        String resultString = (int) result - result == 0.0
                ? Integer.toString((int) result)
                : Double.toString(result);
        this.state.pushToStack(resultString);    }
}
