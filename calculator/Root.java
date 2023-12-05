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
        double number = Double.parseDouble(this.state.popFromStack());
        number = Math.sqrt(number);
        String resultString = (int) number - number == 0.0
                ? Integer.toString((int) number)
                : Double.toString(number);
        this.state.pushToStack(resultString);    }

}
