package calculator;

abstract class Operator {
    private final State state;

    public Operator(State state) {
        this.state = state;
    }

    abstract void execute();
}
