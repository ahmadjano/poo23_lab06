package calculator;
import util.Stack;

/**
 * Clear Class
 */
public class Clear extends ClearError {

    /**
     * Clear constructor
     * @param state - State
     */
    public Clear(State state) {
        super(state);
    }

    /**
     * Execute method
     * Clears app and stack
     */
    @Override
    void execute() {
        super.execute();
        state.setStack(new Stack<>());
    }
}

