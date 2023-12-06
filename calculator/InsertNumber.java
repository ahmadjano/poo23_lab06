package calculator;

/**
 * InsertNumber class
 */
public class InsertNumber extends Operator{
    int value;

    /**
     * @param state - State
     * @param value - Value to add
     */
    public InsertNumber(State state, int value) {
        super(state);
        this.value = value;
    }

    /**
     * Execute Method
     * Adds the number to the currentvalue
     * If the currentvalue has been operated on before, push it to the stack
     */
    @Override
    void execute() {
        if (!this.state.getStatus().equals(State.CalculatorState.ERROR)) {
            if (this.state.getStatus().equals(State.CalculatorState.POST_OPERATION)) {
                this.state.updateStatus(State.CalculatorState.INPUT);
                this.state.pushToStack();
                this.state.resetCurrentValue();
            }
            String strValue = Integer.toString(value);
            if (this.state.isEmpty()) {
                this.state.setCurrentValue(strValue);
                return;
            }
            this.state.setCurrentValue(this.state.getCurrentValue() + strValue);
        }
    }
}
