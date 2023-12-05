package calculator;

public class Submit extends Operator {
    public Submit(State state) {
        super(state);
    }

    /**
     *
     */
    @Override
    void execute() {
        // push the currentValue on top of the stack
        // then set it to 0
        this.state.pushToStack();
<<<<<<< HEAD:calculator/Enter.java
        this.state.resetCurrentValue();
=======
        this.state.resetValue();
>>>>>>> 05aedbfbbdc40f0bbefa59a0163eecdb40f8ca23:calculator/Submit.java
    }
}
