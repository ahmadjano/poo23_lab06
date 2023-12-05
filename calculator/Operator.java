package calculator;

public abstract class Operator {
    protected final State state;

    public Operator(State state) {
        this.state = state;
    }

    abstract void execute();
}
