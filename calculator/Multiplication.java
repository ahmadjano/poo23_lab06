package calculator;

public class Multiplication extends Operator{
    public Multiplication(State state) {
        super(state);
    }

    @Override
    void execute() {
        double n1,n2;
        n1 = Double.parseDouble(this.state.popFromStack());
        n2 = this.state.getCurrentValueAsDouble();
        double result = n1 * n2;
        String resultString = (int) result - result == 0.0
                ? Integer.toString((int) result)
                : Double.toString(result);
        //this.state.pushToStack(resultString);
        this.state.setCurrentValue(resultString);
        this.state.evaluate();
    }
}
