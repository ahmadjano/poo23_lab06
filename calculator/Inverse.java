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
        double number = Double.parseDouble(this.state.popFromStack());
        if (number != 0.0){
            number = 1/number;
        }
        String resultString = (int) number - number == 0.0
                ? Integer.toString((int) number)
                : Double.toString(number);
        this.state.pushToStack(resultString);
    }
}
