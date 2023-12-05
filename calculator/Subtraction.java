package calculator;

public class Subtraction extends Operator{
    public Subtraction(State state) {
        super(state);
    }

    @Override
    void execute() {
        double n1,n2;
        n1 = Double.parseDouble(this.state.popFromStack());
        n2 = this.state.getCurrentValueAsDouble();
        double result = n1 - n2;
        this.state.setCurrentValueFromDouble(result);
        this.state.evaluate();
    }
}
