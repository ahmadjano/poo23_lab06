/**
 * HEIG-VD
 * Laboratoire 6 - Calculatrice
 * @author Ahmad Jano & Richard Aurélien
 * @date 06.12.2023
 */

package calculator;

import util.Stack;

/**
 * Clear class represents an operator that clears the calculator's state and stack.
 * It extends ClearError to handle error-related clearing logic.
 */
public class Clear extends ClearError {

    /**
     * Clear constructor initializes the Clear operator with the calculator's state.
     *
     * @param state - State
     */
    public Clear(State state) {
        super(state);
    }

    /**
     * Execute method clears the calculator's state and stack.
     * It invokes the clearing logic from the superclass ClearError and sets the stack to an empty Stack.
     */
    @Override
    public void execute() {
        super.execute(); // Invoke error-related clearing logic
        state.setStack(new Stack<>()); // Clear the stack
    }
}
