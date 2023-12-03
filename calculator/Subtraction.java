package calculator;

public class Subtraction extends Operator{
    public Subtraction(State state) {
        super(state);
    }

    @Override
    void execute() {
        // subtracts the 2nd item of the stack to the first then add the result on top of the stack
    }
}
