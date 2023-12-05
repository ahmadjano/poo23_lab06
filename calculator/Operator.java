package calculator;

/**
 * Operator class
 * Abstract class for all operators
 */
public abstract class Operator {

    protected final State state;

    /**
     * Operator constructor
     * @param state - State
     */
    public Operator(State state) {
        this.state = state;
    }

    /**
     * Execute method to use the operator
     */
    abstract void execute();
}
