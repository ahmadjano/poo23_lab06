package calculator;

public class Number extends Operator{
    public Number(State state) {
        super(state);
    }

    @Override
    void execute() {
        // add number to the bottom of the queue to be used.
        // exemple : currentValue : 12
        // we add 3 to get currentValue : 123
        // add number to stack when enter pressed
        System.out.println("number");
    }
}
