package calculator;

public class Number extends Operator{
    int value;
    public Number(State state, int value) {
        super(state);
        this.value = value;
    }

    @Override
    void execute() {
        // add number to the bottom of the queue to be used.
        // exemple : currentValue : 12
        // we add 3 to get currentValue : 123
        // add number to stack when enter pressed
        double number = this.state.getCurrentValue();
        System.out.println("number");
    }
}
