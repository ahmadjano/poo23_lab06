package calculator;

public class Addition extends Operator{
    public Addition(State state) {
        super(state);
    }

    @Override
    void execute() {
        System.out.println("Addition");
    }
}
