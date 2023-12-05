package calculator;

import util.Stack;

public class Clear extends ClearError {

    public Clear(State state) {
        super(state);
    }

    @Override
    void execute() {
        super.execute();
        state.setStack(new Stack<>());
    }
}

