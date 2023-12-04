package calculator;

public class Addition extends Operator{
    public Addition(State state) {
        super(state);
    }

    @Override
    void execute() {
        double n1,n2;
        n1 = Double.parseDouble(this.state.popFromStack());
        n2 = Double.parseDouble(this.state.popFromStack());
        double result = n1 + n2;
        this.state.pushToStack(Double.toString(result));
    }
}
