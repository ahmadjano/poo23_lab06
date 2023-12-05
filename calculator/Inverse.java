package calculator;

public class Inverse extends Operator{
    public Inverse(State state) {
        super(state);
    }

    /**
     *
     */
    @Override
    void execute() {
        double number = this.state.getCurrentValueAsDouble();
        if (number != 0.0){
            number = 1/number;
            this.state.setCurrentValueFromDouble(number);
            this.state.evaluate();
        }
    }
}
