package calculator;

public class Root extends Operator{
    public Root(State state) {
        super(state);
    }

    /**
     *
     */
    @Override
    void execute() {
        double number = this.state.getCurrentValueAsDouble();
        number = Math.sqrt(number);
        this.state.setCurrentValueFromDouble(number);
        this.state.evaluate();
    }
}
